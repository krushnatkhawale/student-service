echo "\n Processes before shutdown:\n" > student-service.deleted

ps -ef | grep student-service.jar >> student-service.deleted

echo "\n Processe pid before shutdown:\n" >> student-service.deleted

ps -auxww | grep $(cat student-service.pid) >> student-service.deleted

kill -9 $(cat student-service.pid)

rm student-service.pid

echo "\n Processes after shutdown:\n" >> student-service.deleted

ps -ef | grep student-service.jar >> student-service.deleted
