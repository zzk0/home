#!/bin/sh

LOGS_PATH=/root/home/data/nginx
TODAY=$(date -d 'today' +%Y-%m-%d)

mv ${LOGS_PATH}/error.log ${LOGS_PATH}/error_${TODAY}.log
mv ${LOGS_PATH}/access.log ${LOGS_PATH}/access_${TODAY}.log

docker exec -i home-nginx nginx -s reload