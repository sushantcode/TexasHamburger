pipeline {
  agent any
  stages {
      stage('Build') {
          steps {
              sh 'cd THCSpringBootAPI'
              sh './mvnw clean install'
              sh 'cd ../THCOrderConsumer'
              sh './mvnw clean install'
              sh 'cd ..'
              sh 'docker-compose up --build'
          }
      }
  }
}