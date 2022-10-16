pipeline {
    agent any
    triggers { 
        pollSCM('* * * * * ')
        }
    
    stages {
        stage ('vcs') {
            steps {
                git branch: 'master',
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