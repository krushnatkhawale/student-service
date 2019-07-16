sudo kill -9 $(cat student-service.pid)

echo "App with pid [$(cat student-service.pid)] killed at $(date)" > student-service.deleted

rm  -f student-service.pid