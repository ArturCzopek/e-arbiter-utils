#!/bin/bash

cd $TRAVIS_BUILD_DIR

echo "Build script for e-Arbiter Utils"
echo "Branch: "$TRAVIS_BRANCH

./gradlew build

if [[ $TRAVIS_BRANCH == 'master' ]]
then
  echo "Start sonar analysis"
  ./gradlew sonarqube -Dsonar.host.url=https://sonarqube.com -Dsonar.organization=cyganki -Dsonar.login=$SONAR_TOKEN
else
  echo "No analysis"
fi