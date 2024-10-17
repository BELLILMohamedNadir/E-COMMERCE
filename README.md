
# E-COMMERCE API

This API provides various features such as user creation, authentication, product management, category management, and stock control.




## Technologies
#### 1- Spring Boot.
#### 2- Spring Data JPA
#### 3- Spring Security
#### 4- Hibernate - As the ORM (Object-Relational Mapping)
#### 5- JJWT (Java JWT)
#### 6- MySQL (for production)
#### 7- Maven
#### 8- Validation API (javax.validation)
#### 9- JUnit 5
#### 10- Mockito
## API Reference

### USER
#### Register

```http
  POST /api/auth/register
```

| Parameter | Type     | Description |
| :-------- | :------- | :-----------|
| lastName  | `String` | **Required**|
| firstName | `String` | **Required**|
| address   | `String` | **Required**|
| email     | `String` | **Required**|
| password  | `String` | **Required**|
| age       | `int`    | **Required**|
| role      | `USER/ADMIN`| **Required**|

#### Authentication

```http
  POST /api/auth/authentication
```

| Parameter | Type     | Description |
| :-------- | :------- | :-----------|
| email     | `String` | **Required**|
| password  | `String` | **Required**|

### Product
#### Create

```http
  POST /api/product/create
```

| Parameter | Type     | Description |
| :-------- | :------- | :-----------|
| name      | `String` | **Required**|
| price     | `Float`  | **Required**|
| quantity  | `Long`   | **Required**|
| category  | `Category`| **Required**|
| file      | `MultipartFile`| **Required**|

#### Find

```http
  GET /api/product/find/{id}
```

| Parameter | Type     | Description |
| :-------- | :------- | :-----------|
| id        | `Long`   | **Required**|

#### Find All

```http
  Get /api/product/find/all
```

### Category
#### Create

```http
  POST /api/category/create
```

| Parameter | Type     | Description |
| :-------- | :------- | :-----------|
| name      | `String` | **Required**|

#### Find

```http
  GET /api/category/find/{id}
```

| Parameter | Type     | Description |
| :-------- | :------- | :-----------|
| id        | `Long`   | **Required**|

#### Find All

```http
  Get /api/category/find/all
```

### Order
#### Create

```http
  POST /api/order/create
```

| Parameter | Type     | Description |
| :-------- | :------- | :-----------|
| date      | `Date`   | **Required**|
| user      | `User`   | **Required**|
| products  | `List<Product>`| **Required**|

#### Find

```http
  GET /api/order/find/{id}
```

| Parameter | Type     | Description |
| :-------- | :------- | :-----------|
| id        | `Long`   | **Required**|

### Payment
#### Create

```http
  POST /api/payment/create
```

| Parameter | Type     | Description |
| :-------- | :------- | :-----------|
| date      | `Date`   | **Required**|
| user      | `User`   | **Required**|
| order     | `order`  | **Required**|

#### Find

```http
  GET /api/payment/find/{id}
```

| Parameter | Type     | Description |
| :-------- | :------- | :-----------|
| id        | `Long`   | **Required**|

### Stock
#### Create

```http
  POST /api/stock/create
```

| Parameter | Type     | Description |
| :-------- | :------- | :-----------|
| name      | `String`   | **Required**|
| address   | `String`   | **Required**|
| products  | `List<Product>`| **Not Required**|

#### Find

```http
  GET /api/stock/find/{id}
```

| Parameter | Type     | Description |
| :-------- | :------- | :-----------|
| id        | `Long`   | **Required**|

## Note
You need to add the bearer token to each request, except for the register and authentication requests