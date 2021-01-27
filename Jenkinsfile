def success = true;

pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
            post {
               failure {
                  script { success = false }
               }
            }
        }
        stage('Test') {
            when { expression { success == true } }
            steps {
                sh 'mvn test'
            }
            post {
               failure {
                  script { success = false }
               }
            }
        }
        stage('Code Quality') {
            when { expression { success == true } }
            steps {
                sh 'mvn sonar:sonar'
            }
        }
    }
    post {
        always {
            junit '**/target/surefire-reports/TEST-*.xml'
            emailext to: "djilalisaiah.sid@gmail.com",
                     subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}",
                     attachLog: true,
                     body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}"
        }
    }
}
