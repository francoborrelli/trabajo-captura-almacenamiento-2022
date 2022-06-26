# API REST de Productos

## Pasos para levantar el entorno

### 1. Preparar dataset

Realizar el unzip del archivo `products.tsv.zip` en el directorio `src/main/resources`.

```
unzip src/main/resources/products.tsv.zip -d src/main/resources
```

### 2. Definir el tamaño del dataset a importar

Entre las variables de entorno que recibe el contenedor de api, se encuentra definida la variable SAMPLE_SIZE.

Esta variable de tipo `string` permite definir el porcentaje de datos a importar y a considerar para las pruebas.

Esta variable puede configurarse en `./env/.env.app` y admite los siguientes valores:

- `TINY`: Se corresponde al 10% del tamaño total del dataset. Aproximadamente 43.500 productos.
- `SMALL`: Se corresponde al 25% del tamaño total del dataset. Aproximadamente 109.000 productos.
- `MEDIUM`: Se corresponde al 50% del tamaño total del dataset. Aproximadamente 217.500 productos.
- `LARGE`: Se corresponde al 75% del tamaño total del dataset. Aproximadamente 326.250 productos.
- `FULL`: Se corresponde al 100% del tamaño total del dataset. Aproximadamente 435.000 productos.

Para garantizar pruebas correctas, es recomendable eliminar los volumenes de datos de este proyecto tras cambiar la variable de entorno.

### 3. Buildear imagen de docker

```
docker-compose build
```

### 4. Crear network compartida de docker

```
docker network create app-network
```

### 5. Levantar proyecto

```
docker-compose up -d
```

Al levantar los contenedores por primera vez, se inicializarán las bases de datos y se empezarán a descargar las dependencias definidas en el `.pom`.

Una vez inicializado el contenedor de `api` comenzará la descarga la importación de productos. El avance y finalización de este proceso puede seguirse viendo los logs de dicho contenedor.

```
docker-compose logs -f api
```

A su vez, se puede seguir la importación de datos a Elastic Search viendo los logs del contenedor de logstash:

```
docker-compose logs -f logstash
```

## Endpoints API

### Postgres

```
GET localhost:8080/api/postgres/products/search/{term}
```

Donde `term` corresponde a buscar. Este endpoint devuelve el conjunto de productos que matchean con el término buscado.

```
GET localhost:8080/api/postgres/products/{id}
```

Donde `id` al identificar del producto. Este endpoint devuelve un producto dado su id.

### Elastic

```
GET localhost:8080/api/elastic/products/search/{term}
```

Donde `term` corresponde a buscar. Este endpoint devuelve el conjunto de productos que matchean con el término buscado.

```
GET localhost:8080/api/elastic/products/{id}
```

Donde `id` al identificar del producto. Este endpoint devuelve un producto dado su id.

## Estructura del proyecto

- La carpeta `docker` contiene los Dockerfiles y otros archivos que se copian al momento de buildear la imagen.
- La carpeta `env` contiene los archivos de variables de entornos usadas para configurar los contenedores.
- La carpeta `src` contiene el código fuente del servicio `api`. Esta es la aplicación spring boot utilizada para la API Rest.

## CLEAN UP

Para eliminar contenedores y borrar volumenes asociados a este proyecto se debe correr:

```
docker-compose down -v
```
