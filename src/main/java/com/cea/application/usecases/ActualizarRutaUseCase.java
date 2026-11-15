/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cea.application.usecases;


import com.cea.domain.entities.Ruta;
import com.cea.domain.repositories.RutaRepository;
import com.cea.domain.valueobjects.Jornada;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class ActualizarRutaUseCase {

    private final RutaRepository repositorio;

    public ActualizarRutaUseCase(RutaRepository repositorio) {
        if (repositorio == null) {
            throw new IllegalArgumentException(
                    "El repositorio es obligatorio."
            );
        }

        this.repositorio = repositorio;
    }

    public Optional<Ruta> ejecutar(
            UUID id,
            String nombre,
            String barrio,
            String colegio,
            Set<Jornada> jornadas,
            int capacidadMaxima) {

        if (id == null) {
            throw new IllegalArgumentException(
                    "El identificador es obligatorio."
            );
        }

        Optional<Ruta> resultado = repositorio.buscarPorId(id);

        if (resultado.isEmpty()) {
            return Optional.empty();
        }

        Ruta ruta = resultado.get();

        ruta.actualizarNombre(nombre);
        ruta.actualizarBarrio(barrio);
        ruta.actualizarColegio(colegio);
        ruta.actualizarJornadas(jornadas);
        ruta.actualizarCapacidadMaxima(capacidadMaxima);

        repositorio.guardar(ruta);

        return Optional.of(ruta);
    }
}
