job('NodeJS Docker example') {
    scm {
        git('https://github.com/rkshpanigrahi/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('Rakesh DSL')
            node / gitConfigEmail('rapanigr@cisco.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('node_js') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('rkshpanigrahi/docker-nodejs-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
