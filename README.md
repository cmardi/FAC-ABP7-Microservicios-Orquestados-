# MicroPay - Microservicios Orquestados

## Arquitectura de Microservicios

### Servicios:
- **api-gateway** (8080) - Puerta de enlace central
- **autenticacion** (8081) - Servicio de autenticación JWT
- **usuarios** (8082) - Gestión de usuarios (CRUD)
- **pagos** (8083) - Procesamiento de pagos con Circuit Breaker
- **cuentas** (8084) - Gestión de cuentas bancarias
- **transacciones** (8085) - Historial de transacciones

### Stack Tecnológico:
- Java 17
- Spring Boot 3.4.10
- Maven
- H2 Database (desarrollo)
- JUnit 5 + Mockito (testing)
- JaCoCo (cobertura)

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
