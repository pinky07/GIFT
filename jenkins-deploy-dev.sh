#!/bin/sh
#

IMAGE_NAME='gift-app'

echo 'Stopping container gift-app...'
docker rm 'gift-app'
echo 'Stopping container gift-mysql...'
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
docker run -t  \
    --name $IMAGE_NAME \
    --link gift-mysql:mysql \
    -p 11010:8080 \
    $IMAGE_NAME

echo 'Waiting 30s'
sleep 30s

echo 'Logs...'

docker logs gift-app
docker logs gift-mysql

echo 'Success'