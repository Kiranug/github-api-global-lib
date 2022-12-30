#!/bin/bash
// check out repo
def call(Map config = [:]) {
  sh 'docker images'
  sh 'ls -lrth'
  sh 'docker build -t kiranug/javaapp:$BUILD_NUMBER .'
  sh 'docker push kiranug/javaapp:$BUILD_NUMBER'
  sh 'docker images'
}
