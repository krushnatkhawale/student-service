sudo kill -9 $(cat student-service.pid)

sudo echo "App $(cat student-service.pid) killed at $(date)" > student-service.deleted

sudo rm  -f student-service.pid