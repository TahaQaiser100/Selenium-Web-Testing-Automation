pipeline {
    agent any

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
