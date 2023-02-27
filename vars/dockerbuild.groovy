#!/bin/bash
// check out repo
def call(Map config = [:]) {
  sh 'docker images'
  sh 'ls -lrth'
  sh 'docker build -t "${REGISTRY}/${IMAGE}:${BUILD_NUMBER}" .'
  sh 'docker push "${REGISTRY}/${IMAGE}:${BUILD_NUMBER}"'
  sh 'docker images'
}
