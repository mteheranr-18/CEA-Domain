/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.cea.infrastructure.repositories;

import com.cea.domain.entities.Ruta;
import com.cea.domain.repositories.RutaRepository;
import com.cea.domain.valueobjects.Jornada;
import java.util.EnumSet;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InMemoryRutaRepositoryTest {

    private RutaRepository repositorio;
    private Ruta ruta;

    @BeforeEach
    void configurar() {
        repositorio = new InMemoryRutaRepository();

        ruta = Ruta.crear(
                "Ruta Centro",
                "Centro",
                "Colegio ABC",
                EnumSet.of(Jornada.MANANA),
                10
        );
    }

    @Test
    void debeGuardarUnaRuta() {
        repositorio.guardar(ruta);

        assertTrue(
                repositorio.buscarPorId(ruta.obtenerId()).isPresent()
        );
    }

    @Test
    void debeBuscarUnaRutaPorId() {
        repositorio.guardar(ruta);

        Ruta resultado = repositorio
                .buscarPorId(ruta.obtenerId())
                .orElse(null);

        assertNotNull(resultado);
        assertEquals(ruta.obtenerId(), resultado.obtenerId());
    }

    @Test
    void debeRetornarVacioCuandoLaRutaNoExiste() {
        assertTrue(
                repositorio.buscarPorId(UUID.randomUUID()).isEmpty()
        );
    }

    @Test
    void debeListarTodasLasRutas() {
        Ruta segundaRuta = Ruta.crear(
                "Ruta Norte",
                "Norte",
                "Colegio XYZ",
                EnumSet.of(Jornada.TARDE),
                8
        );

        repositorio.guardar(ruta);
        repositorio.guardar(segundaRuta);

        List<Ruta> resultado = repositorio.listarTodas();

        assertEquals(2, resultado.size());
    }

    @Test
    void debeEliminarUnaRuta() {
        repositorio.guardar(ruta);

        repositorio.eliminar(ruta.obtenerId());

        assertTrue(
                repositorio.buscarPorId(ruta.obtenerId()).isEmpty()
        );
    }

    @Test
    void noDebeGuardarUnaRutaNula() {
        assertThrows(
                IllegalArgumentException.class,
                () -> repositorio.guardar(null)
        );
    }
}

