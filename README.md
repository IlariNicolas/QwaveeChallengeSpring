
# Challenge Qwavee Spring 🚀🍃

El proyecto fue desarrollado utilizando SpringBoot y varias dependencias, entre ellas Lombok, SpringBoot Starter Validation, Spring Web, Devtools, SpringJpa y la dependencia de h2, entre otras.

## Desarrollo del proyecto

En el siguiente diagrama se muestra la estructura general del proyecto y se detallará una explicación.

```html
  ├── controllers
  │   ├── BrandController.java
  │   ├── PriceController.java
  │   └── ProductController.java
  ├── DTOs
  │   ├── BrandGetDto.java
  │   └── ...
  ├── entities
  │   ├── Brand.java
  │   ├── Price.java
  │   └── Product.java
  ├── repositories
  │   ├── BrandRepository.java
  │   ├── PriceRepository.java
  │   └── ProductRepository.java
  ├── services
  │   ├── BrandService.java
  │   ├── PriceService.java
  │   └── ProductService.java
  ```
  La estructura del proyecto presenta 3 capas principales (Controller -> Service -> Repository) las entidades del dominio(Entities) una entidad auxiliar para la transferencia de datos (DTO), Se utilizaron ORM para la creación y mantención de las tablas en base a las entidades definidas, además se agregaron endpoints adicionales para cargar los datos solicitados, se utilizan validaciones en los DTOs para asegurar la integridad de los datos reflejados en la base de datos (H2), ademas de proporcionar los codigos de respuesta correspondientes.
  ### Controllers
  Los controladores son el punto de entrada de la aplicación y la interfaz pública, además estos mismos utilizan DTOs (Data transfer objects) para recibir y enviar información y aplicar validaciones de los datos que estos poseen. Los controladores representan los metodos y acciones disponibles sobre su entidad correspondiente .

  ### Services
La función de los servicios y contener la lógica del negocio y a su vez ser una capa intermedia entre los controladores (punto de entrada de la app) y los repositorios (clases encargadas del contacto con las bases de datos). 

### Repositories
Los repositorios son la capa de la aplicación encargada de la persistencia y de la conexión con las bases de datos, cada repositorio es resposnable de la persistencia de su entidad asignada, los repositorios definidos en este proyecto extiende del JpaRepository el cual posee definidas algunas de las operaciones mas comunes que estos deben realizar (ABM)

### Entities
Las entidades corresponden a la información modelada en el dominio de el proyecto, en este caso serían las marcas,productos y la tarifa de precios, estas entidades poseen la información perteneciente a cada una de ellas, estas entidades mediante un ORM (Asignación objeto-relacional) se ven reflejadas en la base de datos automaticamente

### DTOs
Los DTO(Objetos de transferencia de datos) son clases auxiliares las cuales representan la información parcial o total de alguna de las entidades las cuales tiene que ser comunicada desde o hacia el servidor, estos mismos se encargar mediante de la clase JavaValidator de validar que la información recibida por medio de ellos en un controlador cumpla con condiciones requeridas (no pueden ser nulos, deben ser mayor a un número, demás)



  








## Instalación

Clonar el proyecto de manera local 

```bash
  git clone https://github.com/IlariNicolas/QwaveeChallengeSpring.git
```
    
## Información de la API
### Marca (Brand)🛍️
#### Post marca

```http
  POST /api/brands
```

| Parametro | Tipo     | Descripción                |
| :-------- | :------- | :------------------------- |
| `name` | `String` | **Requerido**. Nombre de la marca |
| `Description` | `String` | **Requerido**. Descripción de la marca |

##### Ejemplo
```json
{
  "name":"ZARA",
  "description":"Is a Spanish multi-national retail clothing chain."
}
```
##### Ejemplo de respuesta
```json
{
    "id": 1,
    "name": "ZARA",
    "description": "Is a Spanish multi-national retail clothing chain."
}
```

### Producto (Product)👔
#### Post producto (El id de su marca debe existir)

```http
  POST /api/product
```

| Parámetro | Tipo     | Descripción                       |
| :-------- | :------- | :-------------------------------- |
| `name`      | `String` | **Requerido**. Nombre del producto |
| `description`| `String` | **Requerido**. Descripcíon del producto |
| `idBrand`      | `int` | **Requerido**. Id de la marca del producto |


##### Ejemplo 
```json
{
    "name":"Brand new Jogger",
    "description":"description of the Jogger",
    "idBrand":1
}
```
##### Ejemplo de respuesta
```json
{
    "id": 3455,
    "name": "Brand new Jogger",
    "description": "description of the Jogger",
    "brand": {
        "id": 1,
        "name": "ZARA",
        "description": "Is a Spanish multi-national retail clothing chain."
    }
}
```

### Tarifa de precio (Price) 📃
#### Post Tarifa de precio (Su producto debe existir)
```http
  POST /api/price
```
| Parámetro | Tipo     | Descripción                       |
| :-------- | :------- | :-------------------------------- |
| `brandId`      | `int` | **Requerido**. Id de marca del producto |
| `productId`| `int` | **Requerido**. Id del producto |
| `priority`      | `int` | **Requerido**. Desambiguador de tarifa de precios(se aplica la más alta) |
| `startDate`      | `String` | **Requerido**. Fecha de inicio de la tarifa de precio(Luego se transforma en date) |
| `endDate`      | `String` | **Requerido**. Fecha de fin de la tarifa|
| `price`      | `float` | **Requerido**. Precio de la tarifa |
| `curr`      | `Currency` | **Requerido**. Moneda en la cual se representa el precio (Contenida en enum de monedas válidas) |

##### Ejemplo
```json
{
  "brandId":1,
  "productId":3455,
  "priority":0,
  "startDate":"06/14/2020 00:00:00",
  "endDate":"12/31/2020 23:59:59",
  "price":35.50,
  "curr":"EUR"
}
```

##### Ejemplo de respuesta 
```json
{
    "brandId": 1,
    "productId": 3455,
    "priority": 0,
    "startDate": "06/14/2020 00:00:00",
    "endDate": "12/31/2020 23:59:59",
    "price": 35.5,
    "curr": "EUR"
}
```
#### Get Tarifa de precio (Con query params)
```http
  GET /api/price?date={$date}&idProduct={#idProduct}&idBrand={$idBrand}
```
##### Parametros de query
| Parámetro | Tipo     | Descripción                       |
| :-------- | :------- | :-------------------------------- |
| `date`      | `Date` | **Requerido**. Fecha para buscar tarifa |
| `idProduct`| `int` | **Requerido**. Id del producto de la tarifa |
| `idBrand`      | `int` | **Requerido**. Id de la marca del producto contenido en tarifa|

##### Ejemplo
```http
GET  http://localhost:9001/api/prices?date=06/14/2020 10:00:00&idProduc=3455&idBrand=1
```
##### Ejemplo de respuesta
```json
{
    "priceList": 1,
    "idBrand": 1,
    "idProduct": 3455,
    "startDate": "2020-06-14-00.00.00",
    "endDate": "2020-12-31-23.59.59",
    "finalPrice": "35.5 EUR"
}
```

## Correr Localmente

1. Una vez clonado el repo debemos abrir el proyecto en el IDE de nuestra preferencia que corra SpringBoot

2. Desde la raiz del proyecto accedemos a y lo corremos con java:
 ```bash
  ./src/main/java/com/qwavee/qwavee_demo/QwaveeDemoApplication.java
```
3. Abrimos Postman y importamos una nueva colección desde 
```bash
  ./QwaveeChallenge.postman_collection.json
```
4. Una vez importada la colección de Postman tendremos una serie de endpoints predefinidos para usar

5. Accedemos a la carpeta Post de la colección importada y accedemos a los archivos "PostBrand" y "PostProduct" y hacemos click en send, en ese respectivo orden para almacenar la marca ZARA y un producto de prueba perteneciente a esta marca

6. Accedemos a la carpeta "Prices" dentro de la carpeta Post y enviamos todas las peticiones almacenadas en esta carpeta para crear los registros de las tarifas de precios

7. Vamos a la carpeta "Price-Test" para hacer las peticiones guardadas las cuales son las definidas en los requerimientos, estas poseen precargadas los datos de testeo solicitados, solo deben enviarse individualmente y podremos observar en la pestaña "Test Results" si nuestros test definidos (definidos en la petición) fueron exitosos.
