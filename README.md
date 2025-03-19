# Duelo de Cartas - API REST con Spring Boot

## Descripción
Sistema de duelo de cartas implementado con Spring Boot y PostgreSQL. Permite batallas entre jugadores y contra la CPU, con un sistema de ventajas de tipo y estrategias de combate.

## Requisitos Previos
- Java 17
- PostgreSQL
- Maven

## Configuración de Base de Datos
1. Crear una base de datos PostgreSQL llamada `duelocartas`
2. Usuario por defecto: `postgres`
3. Contraseña por defecto: `postgres`
4. Puerto por defecto: `5432`

## Instalación y Ejecución
1. Clonar el repositorio
2. Ejecutar: `mvn clean install`
3. Iniciar la aplicación: `mvn spring-boot:run`
4. La aplicación se ejecutará en: `http://localhost:8081`
5. Documentación Swagger: `http://localhost:8081/swagger-ui.html`

## Sistema de Juego

### Cartas Disponibles
| Nombre | Tipo | Ataque | Defensa |
|--------|------|---------|----------|
| Dragón Blanco | Dragon | 3000 | 2500 |
| Dragón Negro | Dragon | 2800 | 2400 |
| Maga Oscura | Mago | 2000 | 1700 |
| Guerrero Flama | Fuego | 1800 | 1600 |
| Ninja de Agua | Agua | 1700 | 1500 |
| Elfa del Bosque | Planta | 1600 | 1800 |

### Sistema de Ventajas
- **Fuego > Planta**: Daño x2
- **Agua > Fuego**: Daño x2
- **Planta > Agua**: Daño x2
- **Dragon vs Dragon**: Daño x1.5

### Endpoints de la API

#### Cartas
- `GET /api/cartas`: Listar todas las cartas
- `POST /api/cartas`: Crear nueva carta
- `GET /api/cartas/{id}`: Obtener carta por ID

#### Jugadores
- `GET /api/jugadores`: Listar jugadores
- `POST /api/jugadores`: Crear nuevo jugador
- `GET /api/jugadores/{id}`: Obtener jugador por ID

#### Batallas
- `POST /api/batallas/cpu?jugadorId={id}`: Iniciar batalla contra CPU
- `POST /api/batallas/{batallaId}/turno?cartaId={id}`: Realizar turno
- `GET /api/batallas/{batallaId}`: Ver estado de batalla
- `GET /api/batallas/activas`: Listar batallas activas
- `DELETE /api/batallas/{batallaId}`: Finalizar batalla

### Ejemplo de Batalla

1. **Iniciar Batalla contra CPU**
```bash
curl -X POST "http://localhost:8081/api/batallas/cpu?jugadorId=1"
```

2. **Realizar Turno**
```bash
curl -X POST "http://localhost:8081/api/batallas/1/turno?cartaId=1"
```

3. **Ver Estado de Batalla**
```bash
curl -X GET "http://localhost:8081/api/batallas/1"
```

## Estructura del Proyecto
```
duelocartas/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/duelocartas/
│       │       ├── controlador/
│       │       ├── modelo/
│       │       ├── repositorio/
│       │       ├── servicio/
│       │       └── config/
│       └── resources/
│           └── application.properties
└── pom.xml
```

## Características
- Sistema de batalla por turnos
- Ventajas de tipo
- IA simple para CPU
- Documentación con Swagger
- Persistencia en PostgreSQL
- RESTful API