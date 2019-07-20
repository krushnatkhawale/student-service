echo "\nProcesses before shutdown:\n" > student-service.deleted

ps -ef | grep "java -jar student-service.jar" | grep ? >> student-service.deleted

echo "\nExisting process pid: $(cat student-service.pid) \n" >> student-service.deleted

echo "\nKilling process with pid - $(cat student-service.pid)\n" >> student-service.deleted

sudo kill -9 $(cat student-service.pid)

sudo rm -f student-service.pid