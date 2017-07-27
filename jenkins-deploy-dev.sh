#!/bin/sh
#

echo 'Removing container gift-mysql...'
docker stop 'gift-mysql'
docker rm 'gift-mysql'

echo 'Removing container gift-app...'
docker stop 'gift-app'
docker rm 'gift-app'

IMAGE_NAME='com.gft/gift:0.0.1-SNAPSHOT'

echo 'Running container... ' $IMAGE_NAME
CONTAINER_ID=`docker run -e 'SPRING_PROFILES_ACTIVE=default,container' -d $IMAGE_NAME`

echo 'Container ID:' $CONTAINER_ID

echo 'Creating MySQL image named gift-mysql'
docker run -d \
    --name gift-mysql \
    -e MYSQL_ROOT_PASSWORD=root \
    -e MYSQL_DATABASE=gift \
    -e MYSQL_USER=user \
    -e MYSQL_PASSWORD=user \
    mysql:latest

echo 'Linking containers...'
docker run -t  \
    --name gift-app \
    --link gift-mysql:mysql \
    -p 11010:8080 \
    $IMAGE_NAME

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
curl -OL https://bintray.com/artifact/download/business/maven/flyway-commandline-3.2.1-linux-x64.tar.gz
tar -xzf flyway-commandline-3.2.1-linux-x64.tar.gz
rm flyway-commandline-3.2.1-linux-x64.tar.gz
chmod +x flyway-3.2.1/flyway

docker run -e FLYWAY_COMMAND=migrate --link link gift-mysql:mysql -v /var/lib/jenkins/workspace/GiFT-App/database/db/:/migrations $IMAGE_NAME

if [ "$FLYWAY_URL" = "" ]; then
	FLYWAY_URL="jdbc:mysql://gift-mysql:3306/gift?useSSL=false"
fi

flyway-3.2.1/flyway $FLYWAY_COMMAND -url=$FLYWAY_URL -user=root -password=root -baselineOnMigrate=true -locations=filesystem:/migrations