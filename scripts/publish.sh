#!/bin/bash

cd $TRAVIS_BUILD_DIR

echo "Branch: "$TRAVIS_BRANCH" pull request: "$TRAVIS_PULL_REQUEST

if [[ $TRAVIS_BRANCH == 'master' && $TRAVIS_PULL_REQUEST == 'false' ]]
then
    echo "Publish new version on maven repository"
    ./gradlew publish
elif [[ $TRAVIS_BRANCH == 'release' && $TRAVIS_PULL_REQUEST == 'false' ]]
then
    echo "Publish new release version on maven repository"
    ./gradlew publish
else
    echo "No publish"
fi
