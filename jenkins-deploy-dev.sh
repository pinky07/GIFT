#!/bin/sh
#

IMAGE_NAME='gift-app'

docker rm 'gift-app'
docker rm 'gift-mysql'

echo 'Creating MySQL image named gift-mysql'
docker run -d \
    --name gift-mysql \
    -e MYSQL_ROOT_PASSWORD=root \
    -e MYSQL_DATABASE=gift \
    -e MYSQL_USER=root \
    -e MYSQL_PASSWORD=root \
    mysql:latest


echo 'Linking containers...'
CONTAINER_ID = docker run -t  \
    --name $IMAGE_NAME \
    --link gift-mysql:mysql \
    -p 11010:8080 \
    $IMAGE_NAME

echo 'Waiting 30s'
sleep 30s

docker logs $CONTAINER_ID

echo 'Success'