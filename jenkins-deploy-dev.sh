#!/bin/sh
#

IMAGE_NAME='com.gft/gift:0.0.1-SNAPSHOT'

echo 'Running container... $IMAGE_NAME'
CONTAINER_ID=`docker run -e 'SPRING_PROFILES_ACTIVE=default,container' -d $IMAGE_NAME`

echo 'Container ID:' $CONTAINER_ID

echo 'Stopping container gift-mysql...'
docker stop 'gift-mysql'
docker rm 'gift-mysql'

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
docker inspect --format='{{.Name}}' $(sudo docker ps -aq --no-trunc)


echo ''
echo 'Logs for GiFT WebApp: ' $CONTAINER_ID

docker logs $CONTAINER_ID


echo ''
echo 'Logs for GiFT MySql'
docker logs gift-mysql

echo 'Success'