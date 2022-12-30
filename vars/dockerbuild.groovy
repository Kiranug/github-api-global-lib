#!/bin/bash
// check out repo
def call(Map config = [:]) {
  sh 'docker images'
  sh 'ls -lrth'
  sh 'docker build -t javatest .'
  sh 'docker image tag kiranug/javatest:latest' 
  sh 'docker images push kiranug/javatest:latest'
  sh 'docker images'
}
