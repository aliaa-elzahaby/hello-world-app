pipeline {
    agent any

    environment {
        AWS_REGION = 'us-east-1'
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Deploy to Dev') {
            steps {
                sh './scripts/deploy.sh dev'
            }
        }

        stage('Deploy to Test') {
            when {
                expression { currentBuild.currentResult == 'SUCCESS' }
            }
            steps {
                sh './scripts/deploy.sh test'
            }
        }

        stage('Deploy to STG') {
            when {
                branch 'master'
            }
            steps {
                sh './scripts/deploy.sh stg'
            }
        }
    }
}
