#!/bin/bash

cd $TRAVIS_BUILD_DIR

echo "Build script for e-Arbiter Utils"
echo "Branch: "$TRAVIS_BRANCH", pull request: "$TRAVIS_PULL_REQUEST

gradlew_output=$(./gradlew build); gradlew_return_code=$?

if (( $TRAVIS_BRANCH == 'master' && $TRAVIS_PULL_REQUEST == 'false' && gradlew_return_code == 0 ))
then
    echo "Gradle build - SUCCESS";
    echo "Start sonar analysis"
    ./gradlew sonarqube -Dsonar.host.url=https://sonarqube.com -Dsonar.organization=cyganki -Dsonar.login=$SONAR_TOKEN
    exit 0;
elif (( gradlew_return_code != 0 ))
then
    echo "!! Gradle build - FAIL !!";
    exit 1;
else
    echo "Gradle build - SUCCESS";
    echo "No analysis"
    exit 0;
fi