echo "\nProcesses before shutdown:\n" > student-service.deleted

ps -ef | grep "java -jar student-service.jar" >> student-service.deleted

echo "\nProcesse pid before shutdown:\n" >> student-service.deleted

ps -auxww | grep $(cat student-service.pid) >> student-service.deleted

echo "\nKilling process with pid - $(cat student-service.pid)\n" >> student-service.deleted

sudo kill -9 $(cat student-service.pid)

rm student-service.pid

echo "\nProcesses after shutdown:\n" >> student-service.deleted

ps -ef | grep "java -jar student-service.jar" >> student-service.deleted
