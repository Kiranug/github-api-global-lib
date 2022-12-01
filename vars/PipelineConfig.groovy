def call() {
  Map pipelineConfig = readYaml(file: "${WORKSPACE}/resources/appconfig/pipeline.yaml")
  return pipelineConfig
}
