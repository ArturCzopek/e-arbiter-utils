#!/bin/bash

cd $TRAVIS_BUILD_DIR

echo "Branch: "$TRAVIS_BRANCH

if [[ $TRAVIS_BRANCH == 'master' ]]
then
  echo "Publish new version on maven repository"
  ./gradlew publish
else
  echo "No publish"
fi
