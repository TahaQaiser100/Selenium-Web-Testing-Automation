pipeline {
    agent{
        docker {
            image 'maven:3.9.16-eclipse-temurin-11-alpine'
        }
    }

    stages {
        stage('Build'){
            steps{
                echo "Build Stage"
                sh 'mvn clean compile'
            }

        }
        stage('Run Tests'){
            steps{
                echo "Run tests"
                sh 'mvn test'
            }

        }
    }

}
