package com.micropay.pagos.servicio;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class PagoServicio {
    private final Random random = new Random();
    
    @CircuitBreaker(name = "bancoExterno", fallbackMethod = "fallbackPago")
    public String procesarPago(Long pagoId) {
        // ✅ AUMENTAR probabilidad de fallo al 70% para activar Circuit Breaker
        if (random.nextDouble() < 0.7) {
            throw new RuntimeException("❌ Banco externo no disponible - Fallo simulado");
        }
        return "✅ Pago #" + pagoId + " procesado exitosamente";
    }

    // Método fallback cuando Circuit Breaker está activo
    public String fallbackPago(Long pagoId, Exception e) {
        return "🔄 Pago #" + pagoId + " en cola - " + e.getMessage();
    }
}
