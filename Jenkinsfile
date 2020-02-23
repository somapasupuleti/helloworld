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
	  stage("SonarQube analysis") {
		agent any
		steps {
		  withSonarQubeEnv('sonar') {
			bat 'mvn sonar:sonar'
		  }
		}
	  }
	  stage("Quality Gate") {
		steps {
		  timeout(time: 1, unit: 'HOURS') {
			waitForQualityGate abortPipeline: true
		  }
		}
	  }       
	}
}
