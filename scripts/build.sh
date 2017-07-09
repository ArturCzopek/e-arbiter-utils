#!/bin/bash

cd $TRAVIS_BUILD_DIR

echo "Build script for e-Arbiter Utils"
echo "Branch: "$TRAVIS_BRANCH" pull request: "$TRAVIS_PULL_REQUEST

./gradlew build

if [[ $TRAVIS_BRANCH == 'master' && $TRAVIS_PULL_REQUEST == 'false' ]]
then
  echo "Start sonar analysis"
  ./gradlew sonarqube -Dsonar.host.url=https://sonarqube.com -Dsonar.organization=cyganki -Dsonar.login=$SONAR_TOKEN
else
  echo "No analysis"
fi