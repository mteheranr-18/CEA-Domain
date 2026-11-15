/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cea.domain.specifications;

import com.cea.domain.entities.Ruta;
import com.cea.domain.valueobjects.Jornada;
import java.util.EnumSet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RutaActivaSpecificationTest {

    private Ruta crearRuta() {

        return Ruta.crear(
                "Colegio Inglés - Colón 9000",
                "Colón",
                "Colegio Inglés",
                EnumSet.of(Jornada.MANANA),
                10
        );
    }

    @Test
    void debeCumplirCuandoLaRutaEstaActiva() {

        Ruta ruta = crearRuta();

        RutaActivaSpecification especificacion =
                new RutaActivaSpecification();

        assertTrue(especificacion.cumple(ruta));
    }

    @Test
    void noDebeCumplirCuandoLaRutaEstaDesactivada() {

        Ruta ruta = crearRuta();
        ruta.desactivar();

        RutaActivaSpecification especificacion =
                new RutaActivaSpecification();

        assertFalse(especificacion.cumple(ruta));
    }

    @Test
    void noDebeCumplirCuandoLaRutaEsNula() {

        RutaActivaSpecification especificacion =
                new RutaActivaSpecification();

        assertFalse(especificacion.cumple(null));
    }
}
