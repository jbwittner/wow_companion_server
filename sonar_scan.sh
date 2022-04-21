#!/bin/sh
CURRENT_GIT_BRANCH=$(git rev-parse --abbrev-ref HEAD)
mvn clean verify sonar:sonar -Dsonar.branch.name=$CURRENT_GIT_BRANCH