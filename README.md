
# Trabajo Final - Captura y Almacenamiento de la Información 2022

## Requisitos

* Docker
* Docker Compose

## Buildear imagen

```
docker-compose -f local.yml build
```

## Levantar proyecto

```
docker-compose -f local.yml up -d
```

## Endpoints

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
