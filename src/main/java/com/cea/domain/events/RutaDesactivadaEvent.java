/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cea.domain.events;

import java.time.LocalDateTime;
import java.util.UUID;

public class RutaDesactivadaEvent {

    private final UUID rutaId;
    private final LocalDateTime fecha;

    public RutaDesactivadaEvent(UUID rutaId) {
        if (rutaId == null) {
            throw new IllegalArgumentException(
                    "El identificador de la ruta es obligatorio."
            );
        }

        this.rutaId = rutaId;
        this.fecha = LocalDateTime.now();
    }

    public UUID obtenerRutaId() {
        return rutaId;
    }

    public LocalDateTime obtenerFecha() {
        return fecha;
    }
}