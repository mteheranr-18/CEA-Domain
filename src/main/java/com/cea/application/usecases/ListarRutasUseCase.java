/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cea.application.usecases;

import com.cea.domain.entities.Ruta;
import com.cea.domain.repositories.RutaRepository;
import java.util.List;

public class ListarRutasUseCase {

    private final RutaRepository repositorio;

    public ListarRutasUseCase(RutaRepository repositorio) {
        if (repositorio == null) {
            throw new IllegalArgumentException(
                    "El repositorio es obligatorio."
            );
        }

        this.repositorio = repositorio;
    }

    public List<Ruta> ejecutar() {
        return repositorio.listarTodas();
    }
}
