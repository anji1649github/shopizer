pipeline {
    agent {lavel 'maven'}
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
        
        }
    }
