pipeline {
        agent any

        environment {
        GCLOUD_CRED = 'canes-268220'
        }

        stages{
                stage('Clone repository') {
                	steps {
                		script {
                			/* atualiza o repo */
                			checkout scm
                		}
                	}
                }

                stage('Build image') {
                	steps {
                       	script {
                       	    /* build da imagem */
                       	    app = docker.build("gcr.io/canes-268220/canes")
                       	}
                    }
                 }

                stage('Test image') {
                	steps {
                        script {
                      		/* Ainda sem testes, implementacao em breve */
                            app.inside {
                            sh 'echo "Tests passed"'
                            }
                        }
                    }
                }

                stage('Push image') {
                	steps {
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
	             stage('Publish') {
                        steps {
                        script {
                        sh "sed -i 's/###BUILDNO###/29/' canes-deployment.yaml"
                        sh "kubectl apply -f canes-deployment.yaml"
                        sh "sleep 5"
                        sh "kubectl get pods -n canes"
                        }
                    }
                }

        }
}
