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
                
                    bat 'mvn test'
                
            }
        }
        stage ('Install Stage') {
            steps {
                
                    bat 'mvn install'
                
            }
        }
		stage ('Sonar Analysis') {
			steps {
					
		    bat 'mvn sonar:sonar'
			}
		}
	}
}
