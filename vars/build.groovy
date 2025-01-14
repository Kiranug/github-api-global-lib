/**
@Library(value="branch", changelog=false) _

function{

    echo "Calling var/function.groovy"

}
**/

import groovy.json.*
import groovy.json.JsonSlurperClassic
import net.sf.json.groovy.JsonSlurper
import groovy.json.JsonOutput
import groovy.json.JsonBuilder
import groovy.io.FileType
import hudson.FilePath;
import jenkins.model.Jenkins;
def call(body) 
{	
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

pipeline {
    agent any 
    stages {
        stage ('Hello World') {
        steps {
        helloWorld()
        }
     }
       stage ('Read Yaml') {
        steps {
            script {
                   def config_json=libraryResource "appconfig/deveast.json"
	               def ConfigInputJSON = new JsonSlurperClassic().parseText(config_json)
				project_id = ConfigInputJSON."${Environment_Name}"."#PROJECT_ID#";
				deployment_credential_id = ConfigInputJSON."${Environment_Name}"."deployment_credential_id";
				build_credential_id = ConfigInputJSON."${Environment_Name}"."build_credential_id";
				cluster_name = ConfigInputJSON."${Environment_Name}"."cluster_name";
				cluster_region = ConfigInputJSON."${Environment_Name}"."cluster_region";
				jump_iap_server = ConfigInputJSON."${Environment_Name}"."jump_iap_server";
				jump_server_region = ConfigInputJSON."${Environment_Name}"."jump_server_region";
                println project_id
            	println deployment_credential_id
            	println cluster_name
            }
        }
     }
    }
}
}
