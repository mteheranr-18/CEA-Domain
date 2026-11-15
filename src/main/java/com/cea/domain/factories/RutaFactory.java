/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cea.domain.factories;

import com.cea.domain.entities.Ruta;
import com.cea.domain.valueobjects.Jornada;
import java.util.Set;

public class RutaFactory {

    public static Ruta crearRuta(
            String nombre,
            String barrio,
            String colegio,
            Set<Jornada> jornadas,
            int capacidadMaxima) {

        return Ruta.crear(
                nombre,
                barrio,
                colegio,
                jornadas,
                capacidadMaxima
        );
    }
}
