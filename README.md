# Trabajo Final - Captura y Almacenamiento de la Información 2022

## Introducción

El objetivo de este proyecto es realizar una comparativa de performace en búsquedas full-text utilizando Postgres y Elastic Search.

## Requisitos

- Docker
- Docker Compose

## Estructura del proyecto

El proyecto está compuesto por dos aplicaciones independientes entre si:

- En la carpeta `app` se encuentra el código fuente para levantar los servicios de las bases de datos y la api de productos.

- En la carpeta `benchmark` se encuentra el código fuente las pruebas para analizar la performance de las consultas sobre elastic y postgres.

En cada carpeta se incluye un readme con las instrucciones para levantar cada uno de los entornos.
