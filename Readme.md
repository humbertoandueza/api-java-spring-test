# APIREST JAVA SPRING 

# Descripción del Proyecto

Este proyecto es una API REST desarrollada en Spring Boot para gestionar clientes. La API proporciona endpoints para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en entidades de clientes. A continuación, se describe cada uno de los principales componentes del proyecto:

## Controlador `ClientController`

El `ClientController` es el componente principal que maneja las solicitudes HTTP y coordina la interacción entre el cliente y los servicios subyacentes.

### **Listar Todos los Clientes**

- **Endpoint:** `GET /api/clients`
- **Descripción:** Recupera una lista paginada de clientes.
- **Parámetros de la Consulta:**
  - `page` (opcional): Número de página (predeterminado: 0).
  - `size` (opcional): Tamaño de la página (predeterminado: 10).
  - `sortBy` (opcional): Campo para ordenar la lista (predeterminado: clientId).
- **Respuesta Exitosa (200 OK):** Retorna una lista paginada de clientes.
- **Respuesta de Error (400 Bad Request):** Retorna un mensaje de error si ocurre una excepción durante la operación.

### **Crear un Nuevo Cliente**

- **Endpoint:** `POST /api/client/create`
- **Descripción:** Crea un nuevo cliente.
- **Cuerpo de la Solicitud:** Objeto `ClientDto` que representa los datos del cliente.
- **Respuesta Exitosa (201 Created):** Retorna un mensaje de éxito y los datos del cliente creado.
- **Respuesta de Error (400 Bad Request):** Retorna un mensaje de error si ocurre una excepción durante la operación.

### **Actualizar un Cliente Existente**

- **Endpoint:** `PUT /api/client/update/{id}`
- **Descripción:** Actualiza los datos de un cliente existente.
- **Parámetro de Ruta:** `id` - Identificador del cliente.
- **Cuerpo de la Solicitud:** Objeto `ClientDto` que contiene los nuevos datos del cliente.
- **Respuesta Exitosa (200 OK):** Retorna un mensaje de éxito y los datos actualizados del cliente.
- **Respuesta de Error (404 Not Found):** Retorna un mensaje de error si el cliente no existe.
- **Respuesta de Error (400 Bad Request):** Retorna un mensaje de error si ocurre una excepción durante la operación.

### **Eliminar un Cliente**

- **Endpoint:** `DELETE /api/client/{id}`
- **Descripción:** Elimina un cliente existente.
- **Parámetro de Ruta:** `id` - Identificador del cliente.
- **Respuesta Exitosa (204 No Content):** Retorna una respuesta vacía indicando éxito.
- **Respuesta de Error (404 Not Found):** Retorna un mensaje de error si el cliente no existe.
- **Respuesta de Error (500 Internal Server Error):** Retorna un mensaje de error si ocurre una excepción durante la operación.

### **Consultar Cliente por ID**

- **Endpoint:** `GET /api/client/{id}`
- **Descripción:** Recupera los detalles de un cliente por su ID.
- **Parámetro de Ruta:** `id` - Identificador del cliente.
- **Respuesta Exitosa (200 OK):** Retorna los detalles del cliente solicitado.
- **Respuesta de Error (404 Not Found):** Retorna un mensaje de error si el cliente no existe.

## Pruebas Unitarias

El proyecto incluye pruebas unitarias para garantizar la calidad y la integridad del código. Estas pruebas cubren casos de éxito y casos de error para cada uno de los métodos del `ClientController`. Puedes ejecutar estas pruebas utilizando un marco de prueba como JUnit.

## Paginación

El endpoint de listado de clientes (`GET /api/clients`) admite paginación para permitir la recuperación de grandes conjuntos de datos de manera eficiente. Los parámetros de consulta (`page`, `size`, `sortBy`) proporcionan flexibilidad para personalizar la respuesta paginada.

## Validaciones

Se han incorporado validaciones en el controlador para garantizar la integridad de los datos y manejar posibles excepciones. Estas validaciones incluyen la verificación de la existencia del cliente antes de realizar actualizaciones o eliminaciones.

Este proyecto proporciona una solución completa para gestionar clientes a través de una API REST segura y eficiente.


## Requisitos previos

Asegúrate de tener instalados los siguientes componentes antes de comenzar:

- [JDK (Java Development Kit)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/downloads)

## Dependencias

Este proyecto utiliza las siguientes dependencias:

- [Spring Boot](https://spring.io/projects/spring-boot) v3.1.5
- [Spring Boot Data JPA](https://spring.io/projects/spring-data-jpa) v3.1.5
- [MySQL Connector/J](https://dev.mysql.com/doc/connector-j/en/) v8.0.23
- [Project Lombok](https://projectlombok.org/) v1.18.22
- [Spring Boot Starter Test](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-testing) v3.1.5
- [ModelMapper](http://modelmapper.org/) v3.1.1
- [Springdoc OpenAPI](https://springdoc.org/) v2.2.0

## Configuración

El archivo de configuración principal es `application.properties`. Aquí tienes un ejemplo de cómo podría verse:

properties
# Configuración del servidor
server.port=8092

# Configuración de la base de datos
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=
spring.datasource.url=jdbc:mysql://localhost/azurian?useSSL=false

# Configuración JPA
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

# Configuración de OpenAPI Swagger
springdoc.swagger-ui.path=/docs.html

# Documentación de la API:

La documentación de la API está disponible en http://localhost:8092/docs. Puedes explorar los endpoints y conocer más sobre cómo interactuar con la API.

En el repositorio se encuentra un archivo db.sql donde se tiene el script de creación de la base de datos, la tabla y el volcado de datos.