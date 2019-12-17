//git凭证ID
def git_auth = "b632ed00-fc81-43c8-a746-5aa0673b2658"
//git的url地址
def git_url = "git@192.168.66.100:itheima_group/tensquare_back.git"


node {
   stage('拉取代码') {
      checkout([$class: 'GitSCM', branches: [[name: "*/${branch}"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: "${git_auth}", url: "${git_url}"]]])
   }

}