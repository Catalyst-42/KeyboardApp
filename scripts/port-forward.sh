#!/bin/zsh
set -e

kubectl port-forward service/api-gateway 8080:8080 -n keyboard-app
