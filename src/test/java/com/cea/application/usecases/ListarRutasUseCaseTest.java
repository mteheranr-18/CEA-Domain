/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cea.application.usecases;

import com.cea.domain.entities.Ruta;
import com.cea.domain.valueobjects.Jornada;
import com.cea.infrastructure.repositories.InMemoryRutaRepository;
import java.util.EnumSet;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ListarRutasUseCaseTest {

    private InMemoryRutaRepository repositorio;
    private ListarRutasUseCase casoDeUso;

    @BeforeEach
    void configurar() {
        repositorio = new InMemoryRutaRepository();
        casoDeUso = new ListarRutasUseCase(repositorio);
    }

    @Test
    void debeListarTodasLasRutas() {

        Ruta ruta1 = Ruta.crear(
                "Ruta Centro",
                "Centro",
                "Colegio ABC",
                EnumSet.of(Jornada.MANANA),
                10
        );

        Ruta ruta2 = Ruta.crear(
                "Ruta Norte",
                "Norte",
                "Colegio XYZ",
                EnumSet.of(Jornada.TARDE),
                8
        );

        repositorio.guardar(ruta1);
        repositorio.guardar(ruta2);

        List<Ruta> resultado = casoDeUso.ejecutar();

        assertEquals(2, resultado.size());
        assertTrue(resultado.contains(ruta1));
        assertTrue(resultado.contains(ruta2));
    }

    @Test
    void debeRetornarListaVaciaCuandoNoHayRutas() {

        List<Ruta> resultado = casoDeUso.ejecutar();

        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
    }

    @Test
    void noDebeCrearElCasoDeUsoSinRepositorio() {

        assertThrows(IllegalArgumentException.class, () ->
                new ListarRutasUseCase(null)
        );
    }
}
