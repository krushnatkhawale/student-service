pipelineLibrary = 'git@github.com:krushnatkhawale/cd-lib.git'

library identifier: 'cd-git@feature-issue2-cucumber-tests-on-feature-branch-only', retriever: modernSCM([ $class: 'GitSCMSource', remote: pipelineLibrary])

pipelineChooser([  "appType": "api" ])