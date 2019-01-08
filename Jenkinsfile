pipeline {
    agent {
        label "maven"
    }

    triggers {
        pollSCM('H/30 * * * *')
    }

    stages {
        stage('Build') {
            when {
                changeRequest target: 'master'
            }
            steps {
                sh 'mvn clean package'
            }
        }
    }

    stages {
        stage('Release') {
            when {
                branch 'master'
            }
            steps {
                sh 'mvn release:prepare -B'
                sh 'mvn release:perform -Darguments="-DsignSkip=false -DdocSkip=false"'
            }
        }
    }
}