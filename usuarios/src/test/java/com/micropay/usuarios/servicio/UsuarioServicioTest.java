package com.micropay.usuarios.servicio;

import com.micropay.usuarios.modelo.Usuario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioServicioTest {
    
    @Test
    void testCrearUsuario_ConDatosValidos_DeberiaRetornarUsuarioConId() {
        // ARRANGE (Preparar)
        UsuarioServicio servicio = new UsuarioServicio();
        Usuario usuarioRequest = new Usuario("Maria Garcia", "maria@email.com", "87654321", "555-9876");

        // ACT (Ejecutar) - Esto FALLARÁ inicialmente
        Usuario usuarioCreado = servicio.crearUsuario(usuarioRequest);

        // ASSERT (Verificar) - Comportamiento esperado
        assertNotNull(usuarioCreado, "El usuario creado no debería ser null");
        assertNotNull(usuarioCreado.getId(), "El usuario debería tener un ID generado");
        assertEquals("Maria Garcia", usuarioCreado.getNombre());
        assertEquals("maria@email.com", usuarioCreado.getEmail());
    }

    @Test
    void testCrearUsuario_ConEmailDuplicado_DeberiaLanzarExcepcion() {
        // ARRANGE
        UsuarioServicio servicio = new UsuarioServicio();
        Usuario usuario1 = new Usuario("Usuario1", "duplicado@email.com", "11111111", "111-1111");
        Usuario usuario2 = new Usuario("Usuario2", "duplicado@email.com", "22222222", "222-2222");

        // ACT - Primero creamos un usuario
        servicio.crearUsuario(usuario1);

        // ASSERT - Segundo usuario con mismo email debería fallar
        Exception exception = assertThrows(RuntimeException.class, () -> {
            servicio.crearUsuario(usuario2);
        });

        assertEquals("Email ya registrado", exception.getMessage());
    }
}