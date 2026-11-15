/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cea.domain.entities;

import com.cea.domain.valueobjects.Telefono;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EstudianteTest {

    @Test
    void debeCrearEstudianteCorrectamente() {

        Telefono telefono = Telefono.crear("3001234567");

        Estudiante estudiante = Estudiante.crear(
            "Miguel",
            telefono
        );

        assertNotNull(estudiante);
        assertEquals("Miguel", estudiante.obtenerNombre());
        assertEquals(telefono, estudiante.obtenerTelefono());
    }

    @Test
    void debeGenerarUnIdAutomaticamente() {

        Telefono telefono = Telefono.crear("3001234567");

        Estudiante estudiante = Estudiante.crear(
            "Miguel",
            telefono
        );

        assertNotNull(estudiante.obtenerId());
    }

    @Test
    void debeRechazarNombreNulo() {

        Telefono telefono = Telefono.crear("3001234567");

        assertThrows(
            IllegalArgumentException.class,
            () -> Estudiante.crear(null, telefono)
        );
    }

    @Test
    void debeRechazarNombreVacio() {

        Telefono telefono = Telefono.crear("3001234567");

        assertThrows(
            IllegalArgumentException.class,
            () -> Estudiante.crear("   ", telefono)
        );
    }

    @Test
    void debeRechazarTelefonoNulo() {

        assertThrows(
            IllegalArgumentException.class,
            () -> Estudiante.crear("Miguel", null)
        );
    }

    @Test
    void debeEliminarEspaciosDelNombre() {

        Telefono telefono = Telefono.crear("3001234567");

        Estudiante estudiante = Estudiante.crear(
            "  Miguel  ",
            telefono
        );

        assertEquals("Miguel", estudiante.obtenerNombre());
    }

    @Test
    void debeActualizarNombreCorrectamente() {

        Telefono telefono = Telefono.crear("3001234567");

        Estudiante estudiante = Estudiante.crear(
            "Miguel",
            telefono
        );

        estudiante.actualizarNombre("Carlos");

        assertEquals("Carlos", estudiante.obtenerNombre());
    }

    @Test
    void debeRechazarActualizacionConNombreVacio() {

        Telefono telefono = Telefono.crear("3001234567");

        Estudiante estudiante = Estudiante.crear(
            "Miguel",
            telefono
        );

        assertThrows(
            IllegalArgumentException.class,
            () -> estudiante.actualizarNombre(" ")
        );
    }

    @Test
    void debeActualizarTelefonoCorrectamente() {

        Telefono telefonoInicial = Telefono.crear("3001234567");
        Telefono telefonoNuevo = Telefono.crear("3101234567");

        Estudiante estudiante = Estudiante.crear(
            "Miguel",
            telefonoInicial
        );

        estudiante.actualizarTelefono(telefonoNuevo);

        assertEquals(telefonoNuevo, estudiante.obtenerTelefono());
    }

    @Test
    void debeRechazarActualizacionConTelefonoNulo() {

        Telefono telefono = Telefono.crear("3001234567");

        Estudiante estudiante = Estudiante.crear(
            "Miguel",
            telefono
        );

        assertThrows(
            IllegalArgumentException.class,
            () -> estudiante.actualizarTelefono(null)
        );
    }

    @Test
    void dosEstudiantesDebenTenerIdentidadesDiferentes() {

        Telefono telefono = Telefono.crear("3001234567");

        Estudiante estudiante1 = Estudiante.crear(
            "Miguel",
            telefono
        );

        Estudiante estudiante2 = Estudiante.crear(
            "Miguel",
            telefono
        );

        assertNotEquals(
            estudiante1.obtenerId(),
            estudiante2.obtenerId()
        );

        assertNotEquals(estudiante1, estudiante2);
    }
}