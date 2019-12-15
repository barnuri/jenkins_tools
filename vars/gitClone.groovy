#!/usr/bin/env groovy
// BRANCH_TO_CLONE came from init func
def call() {
    textWithColor("Git Clone - ${BRANCH_TO_CLONE}")
    checkout([$class: 'GitSCM',
        branches: [[name: BRANCH_TO_CLONE]],
        doGenerateSubmoduleConfigurations: false,
        extensions: [],
        gitTool: 'Default',
        submoduleCfg: [],
        userRemoteConfigs: [[url: GIT_REPO]]
    ])
    textWithColor("Git Clone - Cleans")
    bashCommand("git submodule update --init --recursive || true")
    bashCommand("git submodule foreach 'git checkout ${BRANCH_TO_CLONE} -f || true'")
    bashCommand('git reset --hard || true')
    bashCommand('git clean -dfx || true')
    bashCommand("ls -latr")
    env.LastCommitMessage = bashCommand("git show -s --format=%s")
    env.LastCommitHash = bashCommand("git show -s --format=%h")
    env.LastCommitUser = bashCommand("git show -s --format=%cn")
    env.LastCommitDate = bashCommand("git show -s --format=%ai")   
    textWithColor("Finish Git Clone - ${BRANCH_TO_CLONE}", "green")
}
