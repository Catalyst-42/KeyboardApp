#!/bin/zsh
set -e

cd api-gateway && gradle bootJar && cd ..
cd auth-service && gradle bootJar && cd ..
cd config-server && gradle bootJar && cd ..
cd discovery && gradle bootJar && cd ..
cd layouts-service && gradle bootJar && cd ..
