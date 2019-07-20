#!/usr/bin/env bash

sudo rm -f student-service.deleted

nohup java -jar student-service.jar & echo $! > student-service.pid &