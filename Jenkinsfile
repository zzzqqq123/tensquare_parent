//git凭证ID
def git_auth = "854900d0-f430-4ac7-9034-4e949d986bd0"
//git的url地址
def git_url = "https://github.com/zzzqqq123/tensquare_parent.git"
//镜像的版本号
def tag = "latest"
//Harbor的url地址
def harbor_url = "192.168.206.133:85"
//镜像库项目名称
def harbor_project = "tensquare"
//Harbor的登录凭证ID
def harbor_auth = "24dd69be-31b0-4aed-8d81-ea41ac715b18"

node {
   //获取当前选择的项目名称
   def selectedProjectNames = "${project_name}".split(",")
   //获取当前选择的服务器名称
   def selectedServers = "${publish_server}".split(",")

   stage('拉取代码') {
      checkout([$class: 'GitSCM', branches: [[name: "*/${branch}"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: "${git_auth}", url: "${git_url}"]]])
   }
}