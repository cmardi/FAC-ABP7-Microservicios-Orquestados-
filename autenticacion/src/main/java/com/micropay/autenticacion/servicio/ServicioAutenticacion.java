package com.micropay.autenticacion.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioAutenticacion {

    @Autowired
    private ServicioJwt servicioJwt;

    public String autenticar(String username, String password) {
        // Lógica de autenticación básica - luego integraremos con base de datos
        if ("admin".equals(username) && "password".equals(password)) {
            return servicioJwt.generarToken(username); // JWT real
        }
        return null;
    }
}