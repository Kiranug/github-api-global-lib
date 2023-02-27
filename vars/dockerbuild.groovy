#!/bin/bash
// check out repo
def call(Map config = [:]) {
  sh 'docker images'
  sh 'ls -lrth'
  sh 'az acr build --registry $REGISTRY --image ${IMAGE}:${BUILD_NUMBER} .'
//  sh 'docker build -t "${REGISTRY}/${IMAGE}:${BUILD_NUMBER}" .'
//  sh 'docker push "${REGISTRY}/${IMAGE}:${BUILD_NUMBER}"'
   sh 'docker images'
}
