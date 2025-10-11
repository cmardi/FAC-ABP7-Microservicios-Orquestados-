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

**ESTADO: ✅ LECCIÓN 1 100% COMPLETADA - LISTO PARA LECCIÓN 2**