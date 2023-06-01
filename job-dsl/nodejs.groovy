job('NodeJS example') {
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
        shell("npm install")
    }
}
