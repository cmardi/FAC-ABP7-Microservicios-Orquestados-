package com.micropay.pagos.controlador;

import com.micropay.pagos.servicio.PagoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pagos")
public class PagosControlador {

    @Autowired
    private PagoServicio pagoServicio;

    @PostMapping("/procesar")
    public String procesarPago() {
        Long pagoId = System.currentTimeMillis(); // ID único
        return pagoServicio.procesarPago(pagoId);
    }


    @GetMapping("/test-circuit-breaker")
    public String testCircuitBreaker() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("🔧 Probando Circuit Breaker:\n\n");

        for (int i = 1; i <= 10; i++) {
            try {
                String response = pagoServicio.procesarPago((long) i);
                resultado.append("Intento ").append(i).append(": ").append(response).append("\n");
            } catch (Exception e) {
                resultado.append("Intento ").append(i).append(": ").append(e.getMessage()).append("\n");
            }
        }

        return resultado.toString();
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "✅ Pagos Service OK - Circuit Breaker configurado";
    }
}