/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cea.domain.events;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RutaDesactivadaEventTest {

    @Test
    void debeCrearEventoConRutaIdYFecha() {
        UUID rutaId = UUID.randomUUID();

        RutaDesactivadaEvent evento =
                new RutaDesactivadaEvent(rutaId);

        assertEquals(rutaId, evento.obtenerRutaId());
        assertNotNull(evento.obtenerFecha());
    }

    @Test
    void noDebeCrearEventoSinRutaId() {
        assertThrows(IllegalArgumentException.class, () ->
                new RutaDesactivadaEvent(null)
        );
    }
}