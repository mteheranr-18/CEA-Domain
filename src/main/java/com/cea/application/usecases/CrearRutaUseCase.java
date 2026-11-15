/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cea.application.usecases;

import com.cea.domain.entities.Ruta;
import com.cea.domain.repositories.RutaRepository;
import com.cea.domain.valueobjects.Jornada;
import java.util.Set;

public class CrearRutaUseCase {

    private final RutaRepository repositorio;

    public CrearRutaUseCase(RutaRepository repositorio) {
        if (repositorio == null) {
            throw new IllegalArgumentException(
                    "El repositorio es obligatorio."
            );
        }

        this.repositorio = repositorio;
    }

    public Ruta ejecutar(
            String nombre,
            String barrio,
            String colegio,
            Set<Jornada> jornadas,
            int capacidadMaxima) {

        Ruta ruta = Ruta.crear(
                nombre,
                barrio,
                colegio,
                jornadas,
                capacidadMaxima
        );

        repositorio.guardar(ruta);

        return ruta;
    }
}
