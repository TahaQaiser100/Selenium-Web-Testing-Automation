pipeline {
    agent any

    stages {
        stage('Build'){
            steps{
                echo "Build Stage"
                bat 'mvn clean compile'
            }

        }
        stage('Run Tests'){
            steps{
                echo "Run tests"
                bat 'mvn test'
            }

        }
    }

}