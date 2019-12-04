#!/usr/bin/env groovy

def call(filePath, repo = 'http://registry.codeoasis.com:8081/repository/Files/', user = 'jenkins:zxasqw12') {
    textWithColor("Publish Zip Artifact To Nexus - ${filePath}")
    def fileName = (JOB_NAME + '_' + BUILD_NUMBER + '.zip').replace(" ","_")
    def auth = 'Basic ' + user.bytes.encodeBase64().toString()
    bashCommand("curl -v --user '${user}' --upload-file ${filePath} ${repo + fileName}")
    textWithColor("Done Publish Zip Artifact To Nexus")

    return repo + fileName
}
