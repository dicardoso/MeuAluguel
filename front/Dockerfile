# Etapa 1: build
FROM node:20 AS build
WORKDIR /app
COPY package*.json ./
RUN npm config set strict-ssl false
RUN npm install
COPY . .
CMD ["npm", "run", "dev"]
