pipeline {
    agent any
    stages {
        stage('Checkout source code') {
            steps {
                git branch: 'master', url: 'https://github.com/krushnatkhawale/student-service.git'
            }
        }
        stage('Build') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew build'
            }
        }
    }
}