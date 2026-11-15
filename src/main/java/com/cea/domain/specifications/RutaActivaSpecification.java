/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cea.domain.specifications;

import com.cea.domain.entities.Ruta;

public class RutaActivaSpecification {

    public boolean cumple(Ruta ruta) {

        return ruta != null && ruta.estaActiva();
    }
}
