#!/bin/zsh
set -e

minikube start
eval $(minikube docker-env)

kubectl delete --all pods,deployments,services -n keyboard-app || true

docker build -t config-server:latest ./config-server
docker build -t discovery:latest ./discovery
docker build -t auth-service:latest ./auth-service
docker build -t layouts-service:latest ./layouts-service
docker build -t api-gateway:latest ./api-gateway

docker image prune -f
docker images
