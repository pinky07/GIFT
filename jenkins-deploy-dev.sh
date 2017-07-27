#!/bin/sh
#

IMAGE_NAME='gift-app'

echo 'Stopping container gift-app...'
docker stop 'gift-app'
docker rm 'gift-app'
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
    --name $IMAGE_NAME \
    --link gift-mysql:mysql \
    -p 11010:8080 \
    $IMAGE_NAME

echo 'Waiting 30s'
sleep 30s

echo ''
docker images

echo ''
echo 'Logs for GiFT WebApp'

docker logs $IMAGE_NAME


echo ''
echo 'Logs for GiFT MySql'
docker logs gift-mysql

echo 'Success'