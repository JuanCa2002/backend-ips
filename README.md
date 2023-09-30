# Documentación del Backend - Sistema de Gestión de Citas para IPS

Esta documentación describe la estructura y las funcionalidades del backend de la aplicación de gestión de citas para una Institución Prestadora de Servicios de Salud (IPS).

## Tecnologías Utilizadas

- Java
- Spring Boot
- MySQL

## Estructura del Proyecto

El backend está organizado en varios paquetes que contienen diferentes componentes y funcionalidades. A continuación, se describen los paquetes principales:

### `com.ips.app`

- **`controller`**: Contiene controladores REST que manejan las solicitudes HTTP entrantes y gestionan las respuestas.
- **`service`**: Define servicios que implementan la lógica de negocio de la aplicación.
- **`repository`**: Contiene interfaces de repositorio que interactúan con la base de datos.
- **`model`**: Define modelos de datos que representan entidades en la base de datos.

### `resources`

- **`application.properties`**: Archivo de configuración que contiene propiedades de la aplicación, como la configuración de la base de datos.

## Base de Datos

La base de datos de la aplicación se gestiona utilizando MySQL Workbench. A continuación, se describen las principales tablas y entidades de la base de datos:

- **`pacientes`**: Almacena información sobre los pacientes, como nombres, apellidos, números de identificación, etc.
- **`medicos`**: Contiene datos sobre los médicos, como nombres, especialidades, etc.
- **`citas`**: Registra las citas programadas, incluidos detalles como fecha, hora, estado de la cita, paciente y médico.
- **`encargados`**: Almacena información sobre los encargados que pueden gestionar citas en nombre de los pacientes.
- **`Especialidades`**: Almacena información sobre las especialidades del medico.

## Configuración

Para configurar y ejecutar el backend de la aplicación, sigue estos pasos:

1. Clona el repositorio desde GitHub.
2. Importa el proyecto en tu entorno de desarrollo Java.
3. Configura la conexión a la base de datos en el archivo `application.properties`.
4. Ejecuta la aplicación Spring Boot.

## Endpoints REST

La aplicación backend expone varios endpoints REST que permiten interactuar con la base de datos y gestionar citas, pacientes, médicos y encargados. A continuación, se enumeran algunos de los endpoints principales:

- **`GET /api/pacientes`**: Obtiene la lista de pacientes.
- **`GET /api/medicos`**: Obtiene la lista de médicos.
- **`POST /api/citas`**: Crea una nueva cita.
- **`PUT /api/citas/{id}`**: Actualiza una cita existente.
- **`DELETE /api/citas/{id}`**: Elimina una cita existente.

## Pruebas

Se pueden realizar pruebas unitarias y de integración en el backend para garantizar su funcionamiento correcto. Utiliza herramientas como JUnit y Spring Test para realizar pruebas automatizadas.
