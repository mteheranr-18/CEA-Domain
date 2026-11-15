/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cea.application.usecases;

import com.cea.domain.entities.Ruta;
import com.cea.domain.valueobjects.Jornada;
import com.cea.infrastructure.repositories.InMemoryRutaRepository;
import java.util.EnumSet;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ActualizarRutaUseCaseTest {

    private InMemoryRutaRepository repositorio;
    private ActualizarRutaUseCase casoDeUso;
    private Ruta ruta;

    @BeforeEach
    void configurar() {
        repositorio = new InMemoryRutaRepository();
        casoDeUso = new ActualizarRutaUseCase(repositorio);

        ruta = Ruta.crear(
                "Ruta Centro",
                "Centro",
                "Colegio ABC",
                EnumSet.of(Jornada.MANANA),
                10
        );

        repositorio.guardar(ruta);
    }

    @Test
    void debeActualizarUnaRutaExistente() {

        Optional<Ruta> resultado = casoDeUso.ejecutar(
                ruta.obtenerId(),
                "Ruta Norte",
                "Crespo",
                "Colegio XYZ",
                EnumSet.of(Jornada.TARDE),
                8
        );

        assertTrue(resultado.isPresent());

        Ruta actualizada = resultado.get();

        assertEquals("Ruta Norte", actualizada.obtenerNombre());
        assertEquals("Crespo", actualizada.obtenerBarrio());
        assertEquals("Colegio XYZ", actualizada.obtenerColegio());
        assertEquals(
                EnumSet.of(Jornada.TARDE),
                actualizada.obtenerJornadas()
        );
        assertEquals(8, actualizada.obtenerCapacidadMaxima());
    }

    @Test
    void noDebeActualizarUnaRutaInexistente() {

        Optional<Ruta> resultado = casoDeUso.ejecutar(
                UUID.randomUUID(),
                "Ruta Norte",
                "Crespo",
                "Colegio XYZ",
                EnumSet.of(Jornada.TARDE),
                8
        );

        assertTrue(resultado.isEmpty());
    }

    @Test
    void debeRechazarUnIdentificadorNulo() {

        assertThrows(IllegalArgumentException.class, () ->
                casoDeUso.ejecutar(
                        null,
                        "Ruta Norte",
                        "Crespo",
                        "Colegio XYZ",
                        EnumSet.of(Jornada.TARDE),
                        8
                )
        );
    }

    @Test
    void noDebeCrearElCasoDeUsoSinRepositorio() {

        assertThrows(IllegalArgumentException.class, () ->
                new ActualizarRutaUseCase(null)
        );
    }
}
