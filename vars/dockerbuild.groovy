#!/bin/bash
// check out repo
def call(Map config = [:]) {
  sh 'docker images'
  sh 'docker build -t javatest kiranug/javaapp .'
  sh 'docker push kiranug/javaapp:javatest'
  sh 'docker images'
}
