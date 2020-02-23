@Library('jenkins-library-test')_

import Sample

pipeline {
    agent any
	environment {
       UNIX = isUnix()
    }
	stages {
		stage ('Compile Stage') {
			steps {
			   checkStatus()
			   executeCommand('mvn clean compile')
			}
		}
		stage ('Unit Testing Stage') {
			steps {
			   executeCommand('mvn test')
			}
		}
		stage ('Deployment Stage') {
			steps { 
			   executeCommand('mvn install')
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
	Sample sample = new Sample(1, 3)
	sample.toString()
    if (Boolean.valueOf(env.UNIX)) {
        sh cmd
    }
    else {
        bat cmd
   }
}
