#!/bin/sh
#

echo 'Removing container gift-mysql...'
docker stop 'gift-mysql'
docker rm 'gift-mysql'

echo 'Removing container gift-app...'
docker stop 'gift-app'
docker rm 'gift-app'

IMAGE_NAME='com.gft/gift:0.0.1-SNAPSHOT'

echo 'Creating MySQL image named gift-mysql'
docker run -d \
    --name gift-mysql \
    -e MYSQL_ROOT_PASSWORD=root \
    -e MYSQL_DATABASE=gift \
    -e MYSQL_USER=user \
    -e MYSQL_PASSWORD=user \
    mysql:latest

echo 'Linking containers...'

CONTAINER_ID=`docker run -t \
    --name gift-app \
    -e 'SPRING_PROFILES_ACTIVE=default,container' \
    --link gift-mysql \
    -p 11010:8080 \
    $IMAGE_NAME`

echo 'Container ID:' $CONTAINER_ID

echo 'Waiting 30s'
sleep 30s

echo ''
docker images

echo 'Listing container names'
docker inspect --format='{{.Name}}' $(docker ps -aq --no-trunc)


echo ''
echo 'Logs for GiFT WebApp: ' $CONTAINER_ID

docker logs $CONTAINER_ID

echo ''
echo 'Logs for GiFT MySql'
docker logs gift-mysql

echo 'Success'

cat /etc/hosts

echo 'Flyway...'
apt-get install -y curl
curl -OL https://bintray.com/artifact/download/business/maven/flyway-commandline-4.2.0-linux-x64.tar.gz
tar -xzf flyway-commandline-4.2.0-linux-x64.tar.gz
rm flyway-commandline-4.2.0-linux-x64.tar.gz
chmod +x flyway-3.2.1/flyway

echo 'Link to migrations'
docker run -v /var/lib/jenkins/workspace/GiFT-App/database/db/:/migrations $IMAGE_NAME

if [ "$FLYWAY_URL" = "" ]; then
	FLYWAY_URL="jdbc:mysql://gift-mysql:3306/gift?useSSL=false"
fi

echo 'Calling flyway'
flyway-4.2.0/flyway migrate -url=$FLYWAY_URL -user=root -password=root -locations=filesystem:/migrations