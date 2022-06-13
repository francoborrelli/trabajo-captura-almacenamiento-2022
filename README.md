
# Trabajo Final - Captura y Almacenamiento de la Información 2022

## Requisitos

* Docker
* Docker Compose

## Pasos previos

1. Generar los archivos de variables de entorno en la carpeta `env`. Se incluyen los archivos .dist a modo de referencia.
2. Realizar el unzip del archivo `products.tsv.zip` en el directorio `src/main/resources`.

## Buildear imagen

```
docker-compose -f local.yml build
```

## Levantar proyecto

```
docker-compose -f local.yml up -d
```

## Endpoints API JAVA

### Listar Productos

```
GET localhost:8080/api/v1/products
```

### Get Producto

```
GET localhost:8080/api/v1/products/{id}
```

### Create Product

```
POST localhost:8080/api/v1/products
```

Body:

```json
{
  "name": "test",
  "description": "test description",
}
```

### Update Todo

```
PUT localhost:8080/api/v1/products/{id}
```

Body:

```json
{
  "name": "test",
  "description": "updated description",
}
```

### Delete Todo

```
DELETE localhost:8080/api/v1/products/{id}
```
