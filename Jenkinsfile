pipeline {
  agent any

  tools {
    // Use the tool names you configured in Jenkins
    // Exact names (case-sensitive) must match Jenkins → Global Tool Configuration
    jdk 'JAVA_HOME'
    maven 'MAVEN_HOME'
  }

  environment {
    MVN_OPTS = '-B -U' // batch mode, force updates
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Build & Test') {
      steps {
        // run maven tests
        sh "${tool name: 'MAVEN_HOME', type: 'hudson.tasks.Maven'}/bin/mvn ${MVN_OPTS} test"
      }
    }

    stage('Archive Artifacts') {
      steps {
        archiveArtifacts artifacts: 'target/cucumber-report.html, target/cucumber.json, target/*.xml, target/screenshots/**', fingerprint: true, allowEmptyArchive: true
      }
    }

    stage('Results') {
      steps {
        junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
      }
    }
  }

  post {
    always {
      echo "Pipeline finished. Check archived artifacts."
    }
    failure {
      mail to: 'you@example.com',
           subject: "Jenkins: Build failed ${env.JOB_NAME} #${env.BUILD_NUMBER}",
           body: "See ${env.BUILD_URL} for details"
    }
  }
}
