/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cea.application.usecases;


import com.cea.domain.entities.Ruta;
import com.cea.domain.exceptions.DomainException;
import com.cea.domain.valueobjects.Jornada;
import com.cea.infrastructure.repositories.InMemoryRutaRepository;
import java.util.EnumSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CrearRutaUseCaseTest {

    private InMemoryRutaRepository repositorio;
    private CrearRutaUseCase casoDeUso;

    @BeforeEach
    void configurar() {
        repositorio = new InMemoryRutaRepository();
        casoDeUso = new CrearRutaUseCase(repositorio);
    }

    @Test
    void debeCrearYGuardarUnaRuta() {

        Ruta ruta = casoDeUso.ejecutar(
                "Ruta Centro",
                "Centro",
                "Colegio ABC",
                EnumSet.of(Jornada.MANANA),
                10
        );

        assertNotNull(ruta);

        assertTrue(
                repositorio.buscarPorId(ruta.obtenerId()).isPresent()
        );

        assertEquals("Ruta Centro", ruta.obtenerNombre());
    }

    @Test
    void noDebeCrearUnaRutaConNombreVacio() {

        assertThrows(DomainException.class, () ->
                casoDeUso.ejecutar(
                        "",
                        "Centro",
                        "Colegio ABC",
                        EnumSet.of(Jornada.MANANA),
                        10
                )
        );

        assertTrue(repositorio.listarTodas().isEmpty());
    }

    @Test
    void noDebeCrearUnaRutaConCapacidadInvalida() {

        assertThrows(DomainException.class, () ->
                casoDeUso.ejecutar(
                        "Ruta Centro",
                        "Centro",
                        "Colegio ABC",
                        EnumSet.of(Jornada.MANANA),
                        15
                )
        );

        assertTrue(repositorio.listarTodas().isEmpty());
    }

    @Test
    void noDebeCrearElCasoDeUsoSinRepositorio() {

        assertThrows(IllegalArgumentException.class, () ->
                new CrearRutaUseCase(null)
        );
    }
}
