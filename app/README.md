# API REST de Productos

## Pasos para levantar el entorno

### 1. Preparar dataset

Realizar el unzip del archivo `products.tsv.zip` en el directorio `src/main/resources`.

```
unzip src/main/resources/products.tsv.zip -d src/main/resources
```

### 2. Buildear imagen de docker

```
docker-compose build
```

### 3. Crear network compartida de docker
```
docker network create app-network
```

### 4. Levantar proyecto

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
