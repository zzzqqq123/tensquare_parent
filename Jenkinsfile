//定义一些变量/参数
def git_auth_id = "b632ed00-fc81-43c8-a746-5aa0673b2658"
def git_url = "git@192.168.66.100:itheima_group/tensquare_back.git"


node {
   stage('拉取项目代码') {
         checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: "${git_auth_id}", url: "${git_url}"]]])
   }

}