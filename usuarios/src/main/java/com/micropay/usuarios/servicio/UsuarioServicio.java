package com.micropay.usuarios.servicio;

import com.micropay.usuarios.modelo.Usuario;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UsuarioServicio {
    private final List<Usuario> usuarios = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong(1);
    
    public Usuario crearUsuario(Usuario usuarioRequest) {
        // Verificar email duplicado
        for (Usuario usuarioExistente : usuarios) {
            if (usuarioExistente.getEmail().equals(usuarioRequest.getEmail())) {
                throw new RuntimeException("Email ya registrado");
            }
        }

        // Crear usuario con ID
        Usuario usuarioCreado = new Usuario();
        usuarioCreado.setId(contadorId.getAndIncrement());
        usuarioCreado.setNombre(usuarioRequest.getNombre());
        usuarioCreado.setEmail(usuarioRequest.getEmail());
        usuarioCreado.setDocumento(usuarioRequest.getDocumento());
        usuarioCreado.setTelefono(usuarioRequest.getTelefono());

        usuarios.add(usuarioCreado);
        return usuarioCreado;
    }
}