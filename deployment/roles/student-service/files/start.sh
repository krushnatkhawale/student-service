#!/usr/bin/env bash

sudo nohup java -jar student-service.jar & echo $! > student-service.pid