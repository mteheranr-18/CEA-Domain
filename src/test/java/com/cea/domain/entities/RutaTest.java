/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.cea.domain.entities;

import com.cea.domain.events.RutaDesactivadaEvent;
import com.cea.domain.exceptions.DomainException;
import com.cea.domain.valueobjects.Jornada;
import java.util.EnumSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RutaTest {

    private Ruta crearRutaValida() {
        return Ruta.crear(
                "Colegio Inglés - Colón 9000",
                "Colón",
                "Colegio Inglés",
                EnumSet.of(Jornada.MANANA, Jornada.MEDIODIA),
                10
        );
    }

    @Test
    void debeCrearUnaRutaCorrectamente() {
        Ruta ruta = crearRutaValida();

        assertNotNull(ruta);
        assertEquals("Colegio Inglés - Colón 9000", ruta.obtenerNombre());
        assertEquals("Colón", ruta.obtenerBarrio());
        assertEquals("Colegio Inglés", ruta.obtenerColegio());
        assertEquals(10, ruta.obtenerCapacidadMaxima());
        assertTrue(ruta.estaActiva());
    }

    @Test
    void debeGenerarUnIdentificadorUnico() {
        Ruta ruta1 = crearRutaValida();
        Ruta ruta2 = crearRutaValida();

        assertNotNull(ruta1.obtenerId());
        assertNotEquals(ruta1.obtenerId(), ruta2.obtenerId());
    }

    @Test
    void noDebeCrearRutaConNombreVacio() {
        assertThrows(IllegalArgumentException.class, () ->
                Ruta.crear(
                        " ",
                        "Colón",
                        "Colegio Inglés",
                        EnumSet.of(Jornada.MANANA),
                        10
                )
        );
    }

    @Test
    void noDebeCrearRutaConBarrioVacio() {
        assertThrows(IllegalArgumentException.class, () ->
                Ruta.crear(
                        "Ruta 1",
                        "",
                        "Colegio Inglés",
                        EnumSet.of(Jornada.MANANA),
                        10
                )
        );
    }

    @Test
    void noDebeCrearRutaConColegioVacio() {
        assertThrows(IllegalArgumentException.class, () ->
                Ruta.crear(
                        "Ruta 1",
                        "Colón",
                        " ",
                        EnumSet.of(Jornada.MANANA),
                        10
                )
        );
    }

    @Test
    void noDebeCrearRutaSinJornadas() {
        assertThrows(IllegalArgumentException.class, () ->
                Ruta.crear(
                        "Ruta 1",
                        "Colón",
                        "Colegio Inglés",
                        EnumSet.noneOf(Jornada.class),
                        10
                )
        );
    }

    @Test
    void noDebeCrearRutaConJornadasNulas() {
        assertThrows(IllegalArgumentException.class, () ->
                Ruta.crear(
                        "Ruta 1",
                        "Colón",
                        "Colegio Inglés",
                        null,
                        10
                )
        );
    }

    @Test
    void noDebeCrearRutaConCapacidadInvalida() {
        assertThrows(IllegalArgumentException.class, () ->
                Ruta.crear(
                        "Ruta 1",
                        "Colón",
                        "Colegio Inglés",
                        EnumSet.of(Jornada.MANANA),
                        11
                )
        );
    }

    @Test
    void debeActualizarElNombre() {
        Ruta ruta = crearRutaValida();

        ruta.actualizarNombre("Ruta Nueva");

        assertEquals("Ruta Nueva", ruta.obtenerNombre());
    }

    @Test
    void debeActualizarElBarrio() {
        Ruta ruta = crearRutaValida();

        ruta.actualizarBarrio("Bocagrande");

        assertEquals("Bocagrande", ruta.obtenerBarrio());
    }

    @Test
    void debeActualizarElColegio() {
        Ruta ruta = crearRutaValida();

        ruta.actualizarColegio("Colegio Nuevo");

        assertEquals("Colegio Nuevo", ruta.obtenerColegio());
    }

    @Test
    void debeActualizarLasJornadas() {
        Ruta ruta = crearRutaValida();

        ruta.actualizarJornadas(EnumSet.of(Jornada.TARDE));

        assertEquals(
                Set.of(Jornada.TARDE),
                ruta.obtenerJornadas()
        );
    }

    @Test
    void noDebePermitirModificarLasJornadasExternamente() {
        Ruta ruta = crearRutaValida();

        assertThrows(UnsupportedOperationException.class, () ->
                ruta.obtenerJornadas().add(Jornada.TARDE)
        );
    }

    @Test
    void debeActualizarLaCapacidad() {
        Ruta ruta = crearRutaValida();

        ruta.actualizarCapacidadMaxima(8);

        assertEquals(8, ruta.obtenerCapacidadMaxima());
    }

    @Test
    void noDebeActualizarLaCapacidadConUnValorInvalido() {
        Ruta ruta = crearRutaValida();

        assertThrows(IllegalArgumentException.class, () ->
                ruta.actualizarCapacidadMaxima(15)
        );
    }

    @Test
    void debeDesactivarUnaRuta() {
        Ruta ruta = crearRutaValida();

        ruta.desactivar();

        assertFalse(ruta.estaActiva());
    }

    @Test
    void debeActivarUnaRutaDesactivada() {
        Ruta ruta = crearRutaValida();

        ruta.desactivar();
        ruta.activar();

        assertTrue(ruta.estaActiva());
    }

    @Test
    void dosRutasDiferentesNoDebenSerIguales() {
        Ruta ruta1 = crearRutaValida();
        Ruta ruta2 = crearRutaValida();

        assertNotEquals(ruta1, ruta2);
    }

    @Test
    void unaRutaDebeSerIgualASiMisma() {
        Ruta ruta = crearRutaValida();

        assertEquals(ruta, ruta);
    }

    @Test
    void debeDesactivarRutaYGenerarEvento() {
        Ruta ruta = crearRutaValida();

        RutaDesactivadaEvent evento = ruta.desactivar();

        assertFalse(ruta.estaActiva());
        assertNotNull(evento);
        assertEquals(ruta.obtenerId(), evento.obtenerRutaId());
    }

    @Test
    void noDebeDesactivarUnaRutaDosVeces() {
        Ruta ruta = crearRutaValida();

        ruta.desactivar();

        assertThrows(DomainException.class, ruta::desactivar);
    }
}
