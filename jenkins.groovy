pipeline {
    agent {label 'maven'}
    triggers { 
        pollSCM('* * * * * ')
        }
    stages {
        stage ('vcs') {
            steps {
                git branch: 'develop',
                    url: 'https://github.com/anji1649github/shopizer.git'
            }
        }
            stage ('build') {
            steps {
                sh 'mvn package'  
            }
        }
            stage ('archiveArtifacts') {
                steps {
                    junit '**/surefire-reports/*.xml'
                }
            }
        
        }
    }
