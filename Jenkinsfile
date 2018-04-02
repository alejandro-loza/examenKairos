pipeline {
    agent { docker { image 'maven:3.3.3' } }
    stages {
        stage('build') {
            steps {
                sh './gradlew build && java -jar build/libs/examen-0.0.1-SNAPSHOT.jar'
            }
        }
    }
}
