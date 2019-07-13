kill -9 $(cat student-service.pid)

echo "App killed at $(date)" > student-service.pid