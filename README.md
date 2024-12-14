# Tarea 5 - Administrador de Fotos para Dispositivos

## Descripción del Proyecto

Este proyecto consiste en un administrador de fotos asociadas a dispositivos electrónicos, desarrollado con **SpringBoot** y **Spring Security** como parte de la Tarea 5 del curso **CC5002**. La aplicación permite a un usuario administrador gestionar una galería de fotos ingresadas, implementando las siguientes funcionalidades:

1. **Visualización de Galería:** Muestra una lista de fotos asociadas a dispositivos ordenadas desde la más reciente hasta la más antigua.
2. **Información Adjunta:** Cada foto muestra:
    - Nombre del dispositivo.
    - Correo electrónico del contacto correspondiente.
3. **Eliminación de Fotos:** Los usuarios pueden eliminar fotos proporcionando un motivo. Este motivo, junto con un registro de la acción, se almacena en la base de datos.
4. **Autenticación:** El acceso a la galería está protegido por autenticación mediante Spring Security. Solo el usuario administrador puede acceder a las funcionalidades.

---

## Requisitos del Sistema

- **Java:** Versión 17.
- **Frameworks:**
    - SpringBoot 3.3 o 3.4.
    - Spring Security.
- **Base de Datos:** MySQL.
- **Entorno de Desarrollo:** Maven.
- **Frontend:**
    - HTML5, CSS3, y JavaScript (con uso de AJAX).
    - Compatible con navegadores modernos y resolución mínima de 1024x768.
- **Configuración de Usuario:**
    - Usuario: `admin`
    - Contraseña: `tarea5cc5002`

---

## Estructura del Proyecto

### Backend

- **Configuración:**
    - `SecurityConfig.java`: Configuración de seguridad con autenticación basada en sesiones.
    - `WebConfig.java`: Gestión de recursos estáticos.

- **Controladores:**
    - `AdminController`: Proporciona endpoints para obtener las imágenes y eliminarlas.
    - `AdminPageController`: Renderiza la página de administración protegida.
    - `ArchivoController`: Maneja las APIs públicas relacionadas con los archivos.
    - `DispositivoController`: Proporciona acceso a la información de dispositivos.

- **Modelos:**
    - `Archivo`: Modelo que representa los archivos (fotos).
    - `Contacto`: Representa los contactos asociados a dispositivos.
    - `Dispositivo`: Representa la información de cada dispositivo (nombre, estado, etc.).
    - `Log`: Modelo para registrar las acciones administrativas.
    - **DTO:**
        - `ArchivoDTO`: Objeto de transferencia para cargar datos al frontend.

- **Repositorios:**
    - `ArchivoRepository`: Operaciones de base de datos relacionadas con los archivos.
    - `ContactoRepository`: Operaciones relacionadas con los contactos.
    - `DispositivoRepository`: Gestión de dispositivos.
    - `LogRepository`: Registra las acciones de eliminación.

---

### Frontend

- **HTML:**
    - `admin.html`: Página protegida que muestra la galería.
    - `index.html`: Página de inicio (pública).

- **CSS:**
    - `styles.css`: Estilo principal para la aplicación.
    - `admin.css`: Estilo específico para la galería.

- **JavaScript:**
    - `admin.js`: Manejo dinámico de la galería y eliminación de imágenes con AJAX.
    - `script.js`: Scripts auxiliares.
    - `jquery-3.6.0.min.js`: Biblioteca auxiliar.

---

## Esquema del Proyecto

```plaintext
com.example.tarea4
│
├── config
│   ├── SecurityConfig.java
│   ├── WebConfig.java
│
├── controller
│   ├── AdminController.java
│   ├── AdminPageController.java
│   ├── ArchivoController.java
│   ├── DispositivoController.java
│
├── dto
│   ├── ArchivoDTO.java
│
├── model
│   ├── Archivo.java
│   ├── Contacto.java
│   ├── Dispositivo.java
│   ├── Log.java
│   └── converters
│       ├── EstadoDispositivoConverter.java
│       ├── TipoDispositivoConverter.java
│
├── repository
│   ├── ArchivoRepository.java
│   ├── ContactoRepository.java
│   ├── DispositivoRepository.java
│   ├── LogRepository.java
│
└── Tarea4Application.java
```

---

## Rutas del Proyecto

### Backend

| Ruta               | Método HTTP | Descripción                                  |
|--------------------|-------------|----------------------------------------------|
| `/admin/imagenes`  | GET         | Obtiene la lista de imágenes protegidas.     |
| `/admin/imagenes/{id}` | DELETE  | Elimina una imagen y registra el motivo.     |
| `/api/archivos`    | GET         | Obtiene los datos de imágenes para el frontend. |

---

## Capturas

### Galería de Imágenes

![Galería](path-to-screenshot1.png)

### Modal de Eliminación

![Modal](path-to-screenshot2.png)

---

## Instrucciones de Configuración

1**Configurar la Base de Datos:**
    - Asegúrate de tener un directorio llamado `uploads` en la raíz del proyecto para almacenar las imágenes.

2**Configurar el Archivo `application.properties`:**
   ```properties
    spring.application.name=Tarea4
    spring.datasource.url=jdbc:mysql://localhost:3306/tarea2
    spring.datasource.username=cc5002
    spring.datasource.password=programacionweb
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.open-in-view=false
    spring.security.user.name=admin
    spring.security.user.password=tarea5cc5002
   ```

3**Ejecutar el Proyecto:**
   ```bash
   ./mvnw spring-boot:run
   ```

4**Acceder a la Aplicación:**
    - Galería: [http://localhost:8080/admin](http://localhost:8080/admin)
    - Usuario: `admin`
    - Contraseña: `tarea5cc5002`
