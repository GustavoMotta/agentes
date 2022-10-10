#!/bin/bash
mvn clean install -DskipTests=true
docker build -t fittest/agentes-api .
docker run -p "8080:8080" fittest/agentes-api