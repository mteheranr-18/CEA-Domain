package com.cea.application.usecases;

import com.cea.domain.entities.Ruta;
import com.cea.domain.valueobjects.Jornada;
import com.cea.infrastructure.repositories.InMemoryRutaRepository;
import java.util.EnumSet;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EliminarRutaUseCaseTest {

    private InMemoryRutaRepository repositorio;
    private EliminarRutaUseCase casoDeUso;
    private Ruta ruta;

    @BeforeEach
    void configurar() {
        repositorio = new InMemoryRutaRepository();
        casoDeUso = new EliminarRutaUseCase(repositorio);

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
    void debeEliminarUnaRuta() {

        casoDeUso.ejecutar(ruta.obtenerId());

        assertTrue(
                repositorio.buscarPorId(ruta.obtenerId()).isEmpty()
        );
    }

    @Test
    void noDebeEliminarOtraRuta() {

        UUID idInexistente = UUID.randomUUID();

        casoDeUso.ejecutar(idInexistente);

        assertTrue(
                repositorio.buscarPorId(ruta.obtenerId()).isPresent()
        );
    }

    @Test
    void noDebeEliminarUnaRutaConIdNulo() {

        assertThrows(IllegalArgumentException.class, () ->
                casoDeUso.ejecutar(null)
        );
    }

    @Test
    void noDebeCrearElCasoDeUsoSinRepositorio() {

        assertThrows(IllegalArgumentException.class, () ->
                new EliminarRutaUseCase(null)
        );
    }
}
