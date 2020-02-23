pipeline {
    agent any
	stages {
		env.UNIX = isUnix()
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
			executeSonar()
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


def executeSonar() {
    executeCommand('mvn clean package sonar:sonar')
}

def executeCommand(cmd) {
    if (Boolean.valueOf(env.UNIX)) {
        sh cmd
    }
    else {
        bat cmd
   }
}
