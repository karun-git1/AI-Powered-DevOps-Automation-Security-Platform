pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                script {
                    sh 'docker-compose build'
                }
            }
        }
        stage('Test') {
            steps {
                // Add your test steps here
            }
        }
        stage('Deploy') {
            steps {
                script {
                    sh 'kubectl apply -f k8s/'
                }
            }
        }
    }
}