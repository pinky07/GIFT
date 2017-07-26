#!/bin/sh
#

IMAGE_NAME='com.gft/gift:0.0.1-SNAPSHOT'
echo 'Launching new container based on image' $IMAGE_NAME

docker run -e 'SPRING_PROFILES_ACTIVE=default,container' -d -p 8080:11010 $IMAGE_NAME
echo 'Success'