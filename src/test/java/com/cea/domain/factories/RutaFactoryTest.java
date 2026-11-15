/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cea.domain.factories;

import com.cea.domain.entities.Ruta;
import com.cea.domain.valueobjects.Jornada;
import java.util.EnumSet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RutaFactoryTest {

    @Test
    void debeCrearUnaRutaCorrectamente() {

        Ruta ruta = RutaFactory.crearRuta(
                "Colegio Inglés - Colón 9000",
                "Colón",
                "Colegio Inglés",
                EnumSet.of(Jornada.MANANA, Jornada.MEDIODIA),
                10
        );

        assertNotNull(ruta);
        assertEquals("Colón", ruta.obtenerBarrio());
        assertEquals(10, ruta.obtenerCapacidadMaxima());
    }

    @Test
    void noDebeCrearUnaRutaConCapacidadInvalida() {

        assertThrows(IllegalArgumentException.class, () ->
                RutaFactory.crearRuta(
                        "Ruta 1",
                        "Colón",
                        "Colegio Inglés",
                        EnumSet.of(Jornada.MANANA),
                        15
                )
        );
    }
}
