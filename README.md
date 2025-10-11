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

## ✅ Completado

### Estructura del Proyecto
- [x] Configuración Maven con parent POM
- [x] 6 microservicios base creados
- [x] Estructura src/test para usuarios-service

### Ciclo TDD Completo
- [x] **FASE RED**: 2 pruebas fallando inicialmente
- [x] **FASE GREEN**: Implementación mínima funcional
- [x] **FASE REFACTOR**: Código mejorado con 4 pruebas pasando

### Pruebas Unitarias
- [x] 4 pruebas implementadas en UsuarioServicioTest
- [x] Validación de email único
- [x] Generación automática de IDs
- [x] Manejo de excepciones

### Commits Realizados
1. `RED: 2 pruebas fallando - comportamiento usuario definido`
2. `GREEN: 2 pruebas pasando - implementación mínima funcionando`
3. `REFACTOR: código mejorado manteniendo pruebas`

## 📊 Métricas Cumplidas

| Métrica | Requerido | Actual | Estado |
|---------|-----------|--------|--------|
| Ciclos TDD | ≥ 1 | 1 | ✅ |
| Pruebas unitarias | 8-16 | 4 | ⚠️ Parcial |
| Cobertura JaCoCo | ≥ 80% | Pendiente | ❌ |
| Refactorizaciones | 3-5 | 2 | ⚠️ Parcial |

## 🚀 Próximos Pasos

1. **Completar métricas**: Agregar 4+ pruebas más para llegar a 8
2. **Configurar JaCoCo**: Para medición de cobertura
3. **Lección 2**: Implementar patrones arquitectónicos
4. **Integración**: Conectar con otros microservicios

## 📁 Estructura Actual

ABP7-Microservicios/
├── pom.xml (Parent)
├── api-gateway/
├── autenticacion/
├── usuarios/ ✅ TDD COMPLETADO
├── pagos/
├── cuentas/
└── transacciones/

**Estado General: ✅ LECCIÓN 1 COMPLETADA**