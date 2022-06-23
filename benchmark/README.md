# Benchmark de Productos

Proyecto en node para correr el benchmark.

Para las pruebas se utiliza la librería [api-benchmark](https://www.npmjs.com/package/api-benchmark).

## Pasos para correr el benchmark

### 1. Levantar API Rest de productos

Antes de correr el benchmark es necesario asegurarse de que existan y estén corriendo los servicios definidos en el compose de la carpeta `app` del proyecto base.

### 2. Levantar proyecto

```
docker-compose up -d
```

## CLEAN UP

Para eliminar contenedores y borrar volumenes asociados a este proyecto se debe correr:

```
docker-compose down -v
```
