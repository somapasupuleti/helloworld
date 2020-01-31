pipeline {
    agent any
    stages {
        stage ('Compile Stage') {

            steps {
                
                    bat 'mvn clean compile'
                }
        }
        stage ('Unit Testing Stage') {

            steps {
                
                    bat 'mvn test'
                
            }
        }
        stage ('Deployment Stage') {
            steps {
                
                    bat 'mvn install'
                
            }
        }
	stage ('Sonar Analysis') {
	    when {
	    branch 'master'
	    }
	         steps {
		       bat 'mvn sonar:sonar'
             }
	   	}
   }
}
