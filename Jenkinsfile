pipeline {
  agent any
  stages {
      stage('Build') {
        withEnv(["PATH=$PATH:~/.local/bin"]){
          sh 'ls && ./run.sh'
        }
      }
  }
}