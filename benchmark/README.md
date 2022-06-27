# Benchmark de Productos

Proyecto en node para correr el benchmark.

Para las pruebas se utiliza la librería [api-benchmark](https://www.npmjs.com/package/api-benchmark).

## Pasos para correr el benchmark

### 1. Levantar API Rest de productos

Antes de correr el benchmark es necesario asegurarse de que existan y estén corriendo los servicios definidos en el compose de la carpeta `app` del proyecto base.

Una vez finalizada la importación de productos, es recomendable realizar un stop del servicio de logstash para evitar lecturas adicionales en postgres.

```
docker-compose stop logstash
```

### 2. Seleccionar el modo de ejecución:

Mediante la variable de entorno `BY_PRODUCTS_ONLY` se puede definir que tipo de prueba se va a realizar con el benchmark:

- El valor 0, indica que la prueba se hará con los enddpoints `/search`, realizando las busquedas en full-text search con terminos que aparezcan en el producto o en la marca. Para postgres esto implica hacer un JOIN.

- El valor 1, indica que la prueba se hará con los enddpoints `/search-by-products-only`, realizando las busquedas en full-text search con terminos que aparezcan solo en el producto. Para postgres esto implica no hacer el JOIN.

El valor por defecto a utilizar es `1`.

Este valor puede cambiarse directamente desde el archivo `docker-compose.yml`

### 3. Levantar proyecto

```
docker-compose up -d
```

### 4. Ver resultados

En la carpeta `output` se generará el archivo results.json, donde se muestran los resultados obtenidos por cada consulta realizada.

## CLEAN UP

Para eliminar contenedores y borrar volumenes asociados a este proyecto se debe correr:

```
docker-compose down -v
```
