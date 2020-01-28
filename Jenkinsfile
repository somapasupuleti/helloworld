pipeline {
    agent any
    stages {
        stage ('Compile Stage') {

            steps {
                
                    bat 'mvn clean compile'
                  }
        }
        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'apache-maven-3.6.1') {
                    bat 'mvn test'
                }
            }
        }
        stage ('Install Stage') {
            steps {
                withMaven(maven : 'apache-maven-3.6.1') {
                    bat 'mvn install'
                }
            }
        }
		stage ('Sonar Analysis') {
			steps {
				withMaven(maven : 'apache-maven-3.6.1') {
					bat 'mvn sonar:sonar'
				}
			}
		}
    }
}
