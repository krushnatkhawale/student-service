#!/usr/bin/env bash

sudo rm -f student-service.deleted

sudo nohup java -jar student-service.jar & echo $! > student-service.pid &