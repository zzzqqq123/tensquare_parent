//git凭证ID
def git_auth = "b632ed00-fc81-43c8-a746-5aa0673b2658"
//git的url地址
def git_url = "git@192.168.66.100:itheima_group/tensquare_back.git"


node {
   stage('拉取代码') {
      checkout([$class: 'GitSCM', branches: [[name: "*/${branch}"]], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: "${git_auth}", url: "${git_url}"]]])
   }
   stage('代码审查') {
        //定义当前Jenkins的SonarQubeScanner工具
        def scannerHome = tool 'sonar-scanner'
        //引用当前JenkinsSonarQube环境
        withSonarQubeEnv('sonarqube') {
             sh """
                     cd ${project_name}
                     ${scannerHome}/bin/sonar-scanner
             """
        }

   }
   stage('公共工程的安装') {
        sh "mvn -f ${project_name} clean package"
   }
}