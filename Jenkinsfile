pipeline {
    agent any

    tools {
        jdk 'JDK11'   // Name of JDK installed in Jenkins
        maven 'Maven3'   // Name of Maven installed in Jenkins
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/uttam512/demosite-automation.git'
            }
        }

        stage('Install Dependencies') {
            steps {
                sh "mvn clean install -DskipTests"
            }
        }

        stage('Run Tests') {
            steps {
                sh "mvn test"
            }
        }

    }

    post {
        always {
            echo "Pipeline Completed."

            // Archive test results
            junit 'target/surefire-reports/*.xml'

            // Archive cucumber reports (if you want)
            archiveArtifacts artifacts: 'target/cucumber-report.html', allowEmptyArchive: true
            archiveArtifacts artifacts: 'target/cucumber.json', allowEmptyArchive: true
        }
    }
}
