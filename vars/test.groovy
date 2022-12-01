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
    stage('Hello World') {
      steps {
          script {
              cleanWs()
              echo "below are the values from json"
              def config_json=libraryResource "appconfig/deveast.json"
							def ConfigInputJSON = new JsonSlurperClassic().parseText(config_json)
							RESOURCE_GROUP = ConfigInputJSON."dev"."#RESOURCE_GROUP#";
							cluster_name = ConfigInputJSON."dev"."cluster_name";
							println RESOURCE_GROUP
                    helloWorld(name:"kiran",dayOfWeek:"Tuesday")
             }
      }
    }
  }
}
}
