pipeline {
    agent {label "shopizer"}
    triggers { cron('20 12 * * *')
                      }
    stages {
        stage ('vcs') {
            steps {
                git branch"master"
                url: 'https://github.com/anji1649github/shopizer.git'
                }
            }
                  stage ('merge') {
                    steps {
                     sh """
                        'git checkout develop'
                        'git checkout release'
                        'git merge develop no-ff'
                        'git push -f origin release'
                       """
                         }

               // stage ('archiveArtifacts') {
                 //   steps {
                       // junit '**surefiles-reports/*.xml'
                    //}
              //  }


                  }
    }
}