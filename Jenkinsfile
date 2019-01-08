pipeline {
  agent {
    label "maven"
  }

  triggers {
    pollSCM('H/30 * * * *')
  }
  
  stages {
    stage('Build') {
      steps {
        sh 'mvn deploy -DsignSkip=false -DdocSkip=false'
      }
    }
  }
}