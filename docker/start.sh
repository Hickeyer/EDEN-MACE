#!/bin/bash
export DOCKER_IP=127.0.0.1

echo -e "Downloading Docker base images..."
docker-compose pull

echo -e "\nStarting Docker containers..."
docker-compose up --force-recreate --build -d 

echo -e "\nStarted."