#!/usr/bin/env bash

nohup java -jar student-service.jar & echo $! > student-service.pid