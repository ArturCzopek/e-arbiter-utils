#!/bin/bash

echo "Build script for e-Arbiter Utils"
./gradlew build
echo "Branch: " + $TRAVIS_BRANCH
if [[ $TRAVIS_BRANCH == 'master' ]]
then
  echo "Start sonar analysis"
  ./gradlew sonarqube -Dsonar.host.url=https://sonarqube.com -Dsonar.organization=cyganki -Dsonar.login=$SONAR_TOKEN
else
  echo "No analysis"
fi