pipeline {
    agent any
    
    environment {
        DOCKER_HUB_REPO = 'aliaaahmed432/demo1'
        DOCKER_HUB_CREDENTIALS = credentials('docker-hub-credentials')
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }
        
        stage('Test') {
            steps {
                bat 'mvn test'
            }
            
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Build Docker Image') {
            steps {
                script {
                    // Build with both BUILD_ID and latest tags
                    docker.build("${env.DOCKER_HUB_REPO}:${env.BUILD_ID}")
                    docker.build("${env.DOCKER_HUB_REPO}:latest")
                }
            }
        }
        
        stage('Login to Docker Hub') {
            steps {
                script {
                    // Authenticate with Docker Hub
                    sh "echo ${env.DOCKER_HUB_CREDENTIALS_PSW} | docker login -u ${env.DOCKER_HUB_CREDENTIALS_USR} --password-stdin"
                }
            }
        }
        
        stage('Push to Docker Hub') {
            steps {
                script {
                    // Push both versions
                    docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
                        docker.image("${env.DOCKER_HUB_REPO}:${env.BUILD_ID}").push()
                        docker.image("${env.DOCKER_HUB_REPO}:latest").push()
                    }
                }
            }
        }
        
        stage('Run Locally') {
            steps {
                script {
                    // Stop and remove any existing container
                    sh 'docker stop hello-world-app || true'
                    sh 'docker rm hello-world-app || true'
                    
                    // Run the container locally
                    sh "docker run -d -p 8080:8080 --name hello-world-app ${env.DOCKER_HUB_REPO}:latest"
                }
            }
        }
    }
    
    post {
        always {
            // Cleanup workspace
            cleanWs()
            
            // Logout from Docker Hub
            sh 'docker logout'
        }
        success {
            echo 'Application deployed locally at http://localhost:8080'
        }
    }
}