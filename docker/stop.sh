#!/bin/bash
export DOCKER_IP=127.0.0.1

echo -e "Stopping Docker containers..."
docker-compose kill 

echo -e "\nRemoving Docker containers..."
docker-compose down

echo -e "\nStopped."