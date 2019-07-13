sudo kill -9 $(cat student-service.pid)

sudo echo "App killed at $(date)" > student-service.pid