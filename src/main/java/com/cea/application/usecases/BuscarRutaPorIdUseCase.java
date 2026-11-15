/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cea.application.usecases;

import com.cea.domain.entities.Ruta;
import com.cea.domain.repositories.RutaRepository;
import java.util.Optional;
import java.util.UUID;

public class BuscarRutaPorIdUseCase {

    private final RutaRepository repositorio;

    public BuscarRutaPorIdUseCase(RutaRepository repositorio) {
        if (repositorio == null) {
            throw new IllegalArgumentException(
                    "El repositorio es obligatorio."
            );
        }

        this.repositorio = repositorio;
    }

    public Optional<Ruta> ejecutar(UUID id) {

        if (id == null) {
            throw new IllegalArgumentException(
                    "El identificador es obligatorio."
            );
        }

        return repositorio.buscarPorId(id);
    }
}
