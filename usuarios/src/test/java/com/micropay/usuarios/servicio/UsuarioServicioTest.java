package com.micropay.usuarios.servicio;

import com.micropay.usuarios.modelo.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioServicioTest {

    private UsuarioServicio servicio;

    @BeforeEach
    void setUp() {
        servicio = new UsuarioServicio();
    }

    @Test
    void testCrearUsuario_ConDatosValidos_DeberiaRetornarUsuarioConId() {
        // ARRANGE (Preparar)
        Usuario usuarioRequest = new Usuario("Maria Garcia", "maria@email.com", "87654321", "555-9876");

        // ACT (Ejecutar)
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

    @Test
    void testListarUsuarios_CuandoNoHayUsuarios_DeberiaRetornarListaVacia() {
        // ARRANGE
        // ACT
        var usuarios = servicio.listarUsuarios();

        // ASSERT
        assertTrue(usuarios.isEmpty(), "La lista debería estar vacía inicialmente");
    }

    @Test
    void testCrearUsuario_MultiplesUsuarios_DeberiaGenerarIdsIncrementales() {
        // ARRANGE
        Usuario usuario1 = new Usuario("User1", "user1@email.com", "11111111", "111-1111");
        Usuario usuario2 = new Usuario("User2", "user2@email.com", "22222222", "222-2222");

        // ACT
        Usuario resultado1 = servicio.crearUsuario(usuario1);
        Usuario resultado2 = servicio.crearUsuario(usuario2);

        // ASSERT
        assertEquals(1L, resultado1.getId());
        assertEquals(2L, resultado2.getId());
        assertEquals(2, servicio.listarUsuarios().size());
    }
}