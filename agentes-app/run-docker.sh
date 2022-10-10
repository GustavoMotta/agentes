#!/bin/bash
npm install
npm run build
docker build -t fittest/agentes-app .
echo 'Aplicação respondendo na porta 4200'
docker run -p "4200:80" fittest/agentes-app