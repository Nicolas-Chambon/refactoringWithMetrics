
pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Code Quality') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.projectKey=refactoring-with-metrics -Dsonar.host.url=http://thedawndev.fr:9001 -Dsonar.login=5ed72149bcd7ad53c6f0d45c1289bab9a97d0ddf'
            }
        }
    }
    post {
        always {
            emailext to: "djilalisaiah.sid@gmail.com",
                     subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}",
                     attachLog: true,
                     body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}"
        }
    }
}
