# Biblioteca Spring

API REST académica para gestionar un catálogo de libros y sus solicitudes de préstamo. El proyecto demuestra una arquitectura por capas con Spring Boot y almacenamiento en memoria.

## Funcionalidades

- Crear, listar, consultar, actualizar y eliminar libros.
- Buscar libros por ISBN y autor.
- Consultar el total de libros y ordenarlos por año de publicación.
- Registrar y administrar solicitudes de préstamo.

## Tecnologías

- Java 21
- Spring Boot 3.4
- Maven
- Lombok
- JUnit / Spring Boot Test

## Ejecución local

Requisitos: Java 21.

```bash
./mvnw spring-boot:run
```

En Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

La API queda disponible en `http://localhost:8080`.

## Endpoints principales

| Método | Ruta | Descripción |
|---|---|---|
| `GET` | `/api/v1/libros` | Lista los libros |
| `POST` | `/api/v1/libros` | Agrega un libro |
| `GET` | `/api/v1/libros/{id}` | Busca un libro por ID |
| `GET` | `/api/v1/libros/isbn/{isbn}` | Busca por ISBN |
| `GET` | `/api/v1/libros/autor/{autor}` | Busca por autor |
| `GET` | `/api/v1/solicitudes` | Lista los préstamos |
| `POST` | `/api/v1/solicitudes` | Registra un préstamo |

## Nota

Los datos se mantienen en memoria y se reinician al detener la aplicación. Este repositorio tiene fines educativos.
