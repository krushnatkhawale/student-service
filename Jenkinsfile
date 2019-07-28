pipelineLibrary = 'git@github.com:krushnatkhawale/cd-lib.git'

library identifier: 'cd-git@master', retriever: modernSCM([ $class: 'GitSCMSource', remote: pipelineLibrary])

pipelineChooser([  "appType": "api" ])