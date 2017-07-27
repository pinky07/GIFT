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
    -p 3306:3306 \
    mysql:latest

echo 'Waiting 15s'
sleep 15s

echo 'Docker images'
docker images

echo 'Listing container names'
docker inspect --format='{{.Name}}' $(docker ps -aq --no-trunc)

echo ''
echo 'Logs for GiFT MySql'
docker logs gift-mysql

echo 'Installing Curl...'
yum install -y curl
echo 'Downloading Flyway...'
curl -OL https://repo1.maven.org/maven2/org/flywaydb/flyway-commandline/4.2.0/flyway-commandline-4.2.0-linux-x64.tar.gz

tar -xzf flyway-commandline-4.2.0-linux-x64.tar.gz
rm flyway-commandline-4.2.0-linux-x64.tar.gz
chmod +x flyway-4.2.0/flyway

if [ "$FLYWAY_URL" = "" ]; then
	FLYWAY_URL="jdbc:mysql://gift-mysql:3306/gift?useSSL=false"
fi

echo 'Calling flyway'
flyway-4.2.0/flyway migrate -sqlMigrationPrefix=V -url=$FLYWAY_URL -user=root -password=root -locations=filesystem:/var/lib/jenkins/workspace/GiFT-App/database/db/

echo 'Linking containers...'

CONTAINER_ID=`docker run \
    -p 11010:8080 \
    --name gift-app \
    --link gift-mysql:mysql \
    -e 'SPRING_PROFILES_ACTIVE=default,container' \
    -d $IMAGE_NAME`

echo 'Container ID:' $CONTAINER_ID

echo 'Waiting 30s'
sleep 30s

echo ''
echo 'Logs for GiFT App'
docker logs gift-app
docker logs $CONTAINER_ID

echo 'Success'
