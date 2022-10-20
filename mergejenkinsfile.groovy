pipeline {
    agent {label 'maven'
    }
           triggers { cron('20 12 * * *')
                      }
    stages {
        stage ('vcs') {
            steps {
            git  'https://github.com/anji1649github/shopizer.git'
            }
        }
        stage('merge') {
            steps{
                sh 'git checkout release'
                sh 'git merge origin/develop --no-ff'

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