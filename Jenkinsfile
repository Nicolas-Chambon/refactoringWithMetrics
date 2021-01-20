
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
                sh 'mvn sonar:sonar -Dsonar.projectKey=calculatrice-java -Dsonar.host.url=http://thedawndev.fr:9001 -Dsonar.login=fc9c79729b0dfa3d195d3966bd6e354cba9ec73d'
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
