pipeline {
  agent {
    node {
      label 'master'
    }
  }
  
  environment {
    JENKINS_NODE_COOKIE = 'dontkill'
  }
  
  stages {
    stage('Preparation') { // for display purposes
      steps {
        // clean the workspace
        cleanWs()
      }
    }

    stage('Download') {
      steps {
        // Download code from a GitHub repository
        git branch: 'master', url: 'https://github.com/btkruppa/1808-spring-boot-dev-ops.git'
      }
    }


    stage('MVN Build') {
      steps {
        // Run the maven build
        sh "mvn -Dmaven.test.failure.ignore clean package"
      }
    }
    
    stage('Destroy Old Server') {
      steps {
        script {
          try {
            // kill any running instances
            sh "fuser -k 8080/tcp"
          } catch (all) {
            // if it fails that should mean a server wasn't already running
          }
        }
      }
    }

    stage('Deploy') {            
      steps {
        dir ('target') {
          // run the Janus server
          sh "nohup java -jar spring-boot.jar &"
        }
      }
    }

  }
  
  post {
    always {
      sh "echo 'i always run'"
    }
    
    success {
      sh "echo 'i only run on success'"
    }
    
    unstable {
      sh "echo 'i run when the build is unstable (testing?)'"
    }
    
    failure {
      sh "echo 'i run when things failed'"
    }
    
    changed {
      sh "echo 'i run when there is a successful build after a failed one'"
      sh "echo 'or a failed build after a successful one'"
    }
  }
}