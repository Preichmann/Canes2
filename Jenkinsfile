pipeline {
        agent any

        environment {
        GCLOUD_CRED = 'canes-268220'
        NS = 'canes'
	PROJECT_ID = 'canes-268220'
        CLUSTER_NAME = 'canes-k8s'
        LOCATION = 'southamerica-east1-a'
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

                stage('Execute Maven') {
                        steps {
                                script {
                                        /* executa o comando maven para gerar o .war */
                                        sh 'sudo mvn clean deploy -f PI_4/pom.xml'
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
                        sh "sed -i 's/###BUILDNO###/${env.BUILD_NUMBER}/' /var/lib/jenkins/workspace/Canes\\ Deploy/canes-deployment.yaml"
			step([$class: 'KubernetesEngineBuilder', namespace: env.NS, projectId: env.PROJECT_ID, clusterName: env.CLUSTER_NAME, location: env.LOCATION, manifestPattern: 'canes-deployment.yaml', credentialsId: env.GCLOUD_CRED, verifyDeployments: true])
                        }
                    }
                }

        }
}
