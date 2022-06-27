FROM node:17.8-alpine

ENV TZ=America/Argentina/Buenos_Aires

ENV BY_PRODUCTS_ONLY=1

WORKDIR /app

RUN mkdir output

COPY package.json yarn.lock index.js ./

RUN yarn install

EXPOSE 3000