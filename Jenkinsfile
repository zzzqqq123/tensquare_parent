
node {

   stage('拉取代码') {
checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '854900d0-f430-4ac7-9034-4e949d986bd0', url: 'https://github.com/zzzqqq123/tensquare_parent.git']]])
}

}