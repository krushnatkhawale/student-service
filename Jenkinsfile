pipeline {
    agent node0
    stages {
        stage('Checkout source code') {
            steps {
                git branch: 'master', url: 'https://github.com/krushnatkhawale/student-service.git'
            }
        }
    }
}