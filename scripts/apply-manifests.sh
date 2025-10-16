#!/bin/zsh
set -e

kubectl apply -f manifests/namespace.yaml

# Apply manually one by one to ensure correct boot order
kubectl apply -f manifests/config-server.yaml
kubectl apply -f manifests/discovery.yaml
kubectl apply -f manifests/postgres-auth.yaml
kubectl apply -f manifests/auth-service.yaml
kubectl apply -f manifests/postgres-layouts.yaml
kubectl apply -f manifests/layouts-service.yaml
kubectl apply -f manifests/api-gateway.yaml

kubectl get all -n keyboard-app
