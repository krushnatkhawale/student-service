pipelineLibrary = 'git@github.com:krushnatkhawale/cd-lib.git'

library identifier: 'cd-git@issue-8-master-prod-deployment', retriever: modernSCM([ $class: 'GitSCMSource', remote: pipelineLibrary])

pipelineChooser([  "appType": "api" ])