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
        validarEmailUnico(usuarioRequest.getEmail());
        Usuario usuarioCreado = construirUsuarioConId(usuarioRequest);
        usuarios.add(usuarioCreado);
        return usuarioCreado;
    }

    public List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios);
    }

    private void validarEmailUnico(String email) {
        boolean emailExiste = usuarios.stream()
            .anyMatch(usuario -> usuario.getEmail().equals(email));

        if (emailExiste) {
            throw new RuntimeException("Email ya registrado");
        }
    }

    private Usuario construirUsuarioConId(Usuario usuarioRequest) {
        Usuario usuario = new Usuario();
        usuario.setId(contadorId.getAndIncrement());
        usuario.setNombre(usuarioRequest.getNombre());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setDocumento(usuarioRequest.getDocumento());
        usuario.setTelefono(usuarioRequest.getTelefono());
        return usuario;
    }
}