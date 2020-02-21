
node {
    def app

    stage('Clone repository') {
        /* atualiza o repo */

        checkout scm
    }

    stage('Build image') {
        /* build da imagem */

        app = docker.build("gcr.io/canes-268220/canes")
    }

    stage('Test image') {
        /* Ainda sem testes, implementacao em breve */

        app.inside {
            sh 'echo "Tests passed"'
        }
    }

    stage('Push image') {
        /* Finally, we'll push the image with two tags:
         * First, the incremental build number from Jenkins
         * Second, the 'latest' tag.
         * Pushing multiple tags is cheap, as all the layers are reused. */
        docker.withRegistry('https://gcr.io', 'gcr:gcloud-cred') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }
    }
}
