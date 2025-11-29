pipeline {
    agent any

    tools {
        jdk 'JAVA_HOME'   // Name of JDK installed in Jenkins
        maven 'MAVEN_HOME'   // Name of Maven installed in Jenkins
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
                bat "mvn clean install -DskipTests"
            }
        }

        stage('Run Tests') {
            steps {
                bat "mvn test"
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
