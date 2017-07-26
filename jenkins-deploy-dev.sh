#!/bin/sh
#

IMAGE_NAME='com.gft/gift:0.0.1-SNAPSHOT'

echo 'Creating MySQL image named gift-mysql'
docker run -d \
    --name gift-mysql \
    -e MYSQL_ROOT_PASSWORD=root \
    -e MYSQL_DATABASE=gift \
    -e MYSQL_USER=root \
    -e MYSQL_PASSWORD=root \
    mysql:latest


echo 'Linking containers...'
docker run -it  \
    --name $IMAGE_NAME \
    --link gift-mysql:mysql \
    -p 11010:8080 \
    $IMAGE_NAME

echo 'Success'