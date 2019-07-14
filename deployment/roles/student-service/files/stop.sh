sudo kill -9 $(cat student-service.pid)

echo "App $(cat student-service.pid) killed at $(date)" > student-service.deleted

rm  -f student-service.pid