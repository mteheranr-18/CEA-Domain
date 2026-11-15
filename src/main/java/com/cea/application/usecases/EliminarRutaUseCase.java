/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cea.application.usecases;

import com.cea.domain.repositories.RutaRepository;
import java.util.UUID;

public class EliminarRutaUseCase {

    private final RutaRepository repositorio;

    public EliminarRutaUseCase(RutaRepository repositorio) {
        if (repositorio == null) {
            throw new IllegalArgumentException(
                    "El repositorio es obligatorio."
            );
        }

        this.repositorio = repositorio;
    }

    public void ejecutar(UUID id) {

        if (id == null) {
            throw new IllegalArgumentException(
                    "El identificador es obligatorio."
            );
        }

        repositorio.eliminar(id);
    }
}
