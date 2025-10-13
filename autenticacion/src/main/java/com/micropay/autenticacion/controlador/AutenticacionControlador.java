package com.micropay.autenticacion.controlador;

import com.micropay.autenticacion.modelo.dto.LoginRequest;
import com.micropay.autenticacion.servicio.ServicioAutenticacion; // Este import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AutenticacionControlador {

    @Autowired
    private ServicioAutenticacion servicioAutenticacion;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Tu código existente aquí
        String token = servicioAutenticacion.autenticar(
            loginRequest.getUsername(),
            loginRequest.getPassword()
        );

        if (token != null) {
            return ResponseEntity.ok().body("{\"token\": \"" + token + "\"}");
        } else {
            return ResponseEntity.badRequest().body("{\"error\": \"Credenciales inválidas\"}");
        }
    }
}