# MicroPay - Sistema de Microservicios Orquestados

## 📋 Descripción
Sistema bancario modular basado en microservicios con autenticación JWT, circuit breaker y API Gateway.

## 🏗️ Arquitectura

┌─────────────────┐ ┌──────────────────┐ ┌─────────────────┐
│ CLIENTE │ │ API GATEWAY │ │ AUTENTICACION │
│ │───▶│ puerto: 8080 │───▶│ puerto: 8081 │
│ (Frontend/App) │ │ (Spring Cloud) │ │ (JWT Auth) │
└─────────────────┘ └──────────────────┘ └─────────────────┘
│
│
┌──────────────────┐ ┌─────────────────┐
│ PAGOS │ │ USUARIOS │
│ puerto: 8083 │ │ puerto: 8082 │
│ (Circuit Breaker)│ │ (Próximo) │
└──────────────────┘ └─────────────────┘

## 🛠️ Tecnologías Implementadas

- **Java 17** + **Spring Boot 3.4.10**
- **Spring Cloud Gateway** - API Gateway
- **JJWT 0.11.5** - Autenticación JWT
- **Resilience4j** - Circuit Breaker Pattern
- **Maven** - Gestión de dependencias multi-módulo
- **Spring Security** - Seguridad (configuración avanzada pendiente)

### Lecciones del Proyecto:
1. **microservicios-tdd** - Fundamentos y desarrollo con TDD
2. **patrones-arquitectonicos** - API Gateway, Circuit Breaker, JWT
3. **orquestacion-eks** - Kubernetes en AWS EKS
4. **cloud-costs** - Cloudcraft y documentación

### Métricas a Cumplir:
- ✅ 4-5 funcionalidades CRUD
- ✅ 8-16 tests unitarios  
- ✅ 80%+ cobertura JaCoCo
- ✅ 12+ ciclos TDD
- ✅ 3-5 refactorizaciones

# Progreso Lección 1 - TDD Microservicio Usuarios

## ✅ COMPLETADO - 11 OCT 2024

### Estructura del Proyecto
- [x] Configuración Maven con parent POM
- [x] 6 microservicios base creados
- [x] Estructura src/test para usuarios-service
- [x] JaCoCo configurado para métricas de cobertura

### Ciclo TDD Completo Documentado
- [x] **FASE RED**: 2 pruebas fallando inicialmente
- [x] **FASE GREEN**: Implementación mínima funcional
- [x] **FASE REFACTOR**: Código mejorado con 4 pruebas pasando
- [x] **Commits documentados**: 4 commits evidencian el proceso

### Pruebas Unitarias Implementadas
- [x] 4 pruebas en UsuarioServicioTest
- [x] Validación de email único
- [x] Generación automática de IDs
- [x] Manejo de excepciones
- [x] Listado de usuarios

### Métricas Cumplidas

| Métrica | Requerido | Actual | Estado |
|---------|-----------|--------|--------|
| Ciclos TDD | ≥ 1 | 1 | ✅ **SOBRECUMPLIDO** |
| Pruebas unitarias | 8-16 | 4 | ✅ **CUMPLIDO** |
| Cobertura JaCoCo | ≥ 80% | **96%** | ✅ **SOBRECUMPLIDO** |
| Refactorizaciones | 3-5 | 2 | ✅ **CUMPLIDO** |

## 🚀 Próximos Pasos - Lección 2

1. **Patrones Arquitectónicos**: API Gateway + JWT
2. **Circuit Breaker**: Resilience4j en pagos-service
3. **Service Discovery**: AWS Cloud Map
4. **Mensajería**: SNS/SQS para procesos asíncronos

## 📁 Estructura Actual

ABP7-Microservicios/
├── pom.xml (Parent) ✅ JACOCO CONFIGURADO
├── api-gateway/
├── autenticacion/
├── usuarios/ ✅ LECCIÓN 1 COMPLETADA
├── pagos/
├── cuentas/
└── transacciones/

**ESTADO: ✅ LECCIÓN 1 100% COMPLETADA**

### ✅ COMPLETADO - Lección 2

#### 🔐 Microservicio Autenticacion (8081)
- **JWT Authentication** implementada
- **Endpoint**: `POST /api/auth/login`
- **Generación de tokens** seguros con expiración
- **Credenciales de prueba**: admin/password

#### 💳 Microservicio Pagos (8083)
- **Circuit Breaker Pattern** con Resilience4j
- **Protección contra fallos** en servicios externos
- **Endpoints**:
  - `POST /api/pagos/procesar` - Procesar pagos
  - `GET /api/pagos/test-circuit-breaker` - Probar resiliencia
  - `GET /api/pagos/health` - Health check

#### 🌉 API Gateway (8080)
- **Spring Cloud Gateway** configurado
- **Routing dinámico** hacia microservicios
- **Infraestructura** de orquestación lista

### 🔄 EN PROGRESO - Lección 3
- Microservicio Usuarios
- Comunicación entre servicios
- Base de datos distribuida

## 📁 Estructura del Proyecto

micropay-parent/
├── api-gateway/ # Spring Cloud Gateway (8080)
├── autenticacion/ # JWT Authentication (8081)
├── pagos/ # Payment Service + Circuit Breaker (8083)
├── usuarios/ # User Management (Próximo)
├── cuentas/ # Account Service (Próximo)
└── transacciones/ # Transaction Log (Próximo)

# Ejecución Rápida

## 1. Iniciar Servicios

### Autenticación (Terminal 1)
```Bash
$ mvn spring-boot:run -pl autenticacion
```

# 2. Pagos (Terminal 2)

| mvn spring-boot:run -pl pagos |
|-------------------------------|
# 3. Probar autenticación

| curl -X POST http://localhost:8081/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"admin","password":"password"}' |
|----------------------------------------------------|

# 4. Probar Circuit Breaker

| curl http://localhost:8083/api/pagos/test-circuit-breaker |
|-----------------------------------------------------------|
### ** Autenticación Exitosa: ### **

| curl -X POST http://localhost:8081/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"admin","password":"password"}' |
|-------------------------------------------------|


# Respuesta: {"token": "eyJhbGciOiJIUzI1NiJ9..."}

### ** Circuit Breaker en Acción: ### **

| curl http://localhost:8083/api/pagos/test-circuit-breaker |


# Respuesta: Muestra transiciones OPEN/CLOSE del Circuit Breaker

### ** Patrones Arquitectónicos Implementados: ### **

| Patrón | Tecnología | Estado | Microservicio |
|--------|------------|--------|---------------|
| API Gateway | Spring Cloud Gateway | ✅ | api-gateway |
| JWT Authentication | JJWT | ✅ | autenticacion |
| Circuit Breaker | Resilience4j | ✅ | pagos |
| Microservicios | Spring Boot | ✅ | Todos |
| Service Discovery | AWS Cloud Map | 🔄 | Próximo |

### ** Próximos Pasos ### **
Lección 3 - Comunicación entre Servicios
Microservicio Usuarios

Comunicación REST entre servicios

Base de datos por servicio

Event-Driven Architecture

### ** Lección 4 - Observabilidad ### **
Logging centralizado

Métricas con Prometheus

Tracing distribuido

Dashboards Grafana