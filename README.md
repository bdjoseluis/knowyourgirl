# KnowYourGirl — API

**API REST para organizar personas en grupos.** Spring Boot 3 + JPA sobre PostgreSQL,
documentada con Swagger y desplegada en contenedor.

Frontend que la consume: [knowyourgirl-frontend](https://github.com/bdjoseluis/knowyourgirl-frontend)

---

## Qué expone

| Recurso | Campos |
|---|---|
| **Persona** | nombre, descripción, edad, ciudad, grupo al que pertenece |
| **Grupo** | agrupa personas; relación uno-a-muchos gestionada con JPA |

CRUD completo sobre ambos, con DTOs propios para no sacar las entidades de JPA
directamente por la API.

Documentación interactiva en **`/swagger-ui.html`** una vez arrancado.

## Cómo está organizado

```
src/main/java/knowyourgirl/
├── modelo/entities/     Persona · Grupo          (entidades JPA)
├── dto/                 PersonaDto · GrupoDto    (lo que viaja por la API)
├── repository/          Spring Data JPA
├── modelo/services/     lógica de negocio
└── restController/      endpoints REST
```

## Stack

Java · Spring Boot 3 · Spring Data JPA · PostgreSQL · springdoc-openapi (Swagger) ·
Maven · Docker

## Ejecutarlo

La configuración de base de datos va por **variables de entorno**; el repositorio no
lleva credenciales dentro.

```bash
export DB_USER=tu_usuario
export DB_PASSWORD=tu_contraseña
./mvnw spring-boot:run          # http://localhost:8087
```

O con Docker:

```bash
docker build -t knowyourgirl .
docker run -p 8087:8087 -e DB_USER=... -e DB_PASSWORD=... knowyourgirl
```

`spring.jpa.hibernate.ddl-auto=update` crea las tablas solas la primera vez.

## Estado

Proyecto de formación, terminado. Empezó sobre MySQL en local y acabó migrado a
PostgreSQL en la nube, que es el motivo de que la configuración esté parametrizada.
