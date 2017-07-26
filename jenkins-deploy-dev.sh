#!/bin/sh
#

echo 'Creating MySQL image named gift-mysql'
docker run -d \
    --name gift-mysql \
    -e MYSQL_ROOT_PASSWORD=root \
    -e MYSQL_DATABASE=gift \
    -e MYSQL_USER=root \
    -e MYSQL_PASSWORD=root \
    mysql:latest

IMAGE_NAME='com.gft/gift:0.0.1-SNAPSHOT'
echo 'Launching new container based on image' $IMAGE_NAME

CONTAINER_ID=`docker run -e 'SPRING_PROFILES_ACTIVE=default,container' -d -p 11010:8080 $IMAGE_NAME`
echo 'Container ID' $CONTAINER_ID

echo 'Linking containers...'
docker run -it \
    --name $IMAGE_NAME \
    --link gift-mysql:mysql \
    -p 11010:8080 \
    $IMAGE_NAME

echo 'Waiting 30s'
sleep 30s

docker logs $CONTAINER_ID

echo 'Success'