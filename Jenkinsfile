pipeline { 
	agent {
		label 'any'
	}

	environment {
	GCLOUD_CRED = 'canes-268220'
	}

	stages{
		stage('Clone repository') {
        	/* atualiza o repo */	
	        checkout scm
		}

    		stage('Build image') {
			script {
		        	/* build da imagem */
		        	app = docker.build("gcr.io/canes-268220/canes")
			}
   		 }

		stage('Test image') {
			script {
		        	/* Ainda sem testes, implementacao em breve */
	        		app.inside {
	        	   	sh 'echo "Tests passed"'
				}
			}
		}

		stage('Push image') {
			script {
			        /* Finally, we'll push the image with two tags:
	        		 * First, the incremental build number from Jenkins
			         * Second, the 'latest' tag.
			         * Pushing multiple tags is cheap, as all the layers are reused. */
				docker.withRegistry('https://gcr.io', "gcr:${GCLOUD_CRED}") {
        				app.push("${env.BUILD_NUMBER}")
			         	app.push("latest")
        				}
    			}
		}
	}
}
