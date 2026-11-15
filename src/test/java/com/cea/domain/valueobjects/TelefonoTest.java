/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cea.domain.valueobjects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TelefonoTest {

    @Test
    void debeCrearTelefonoValido() {

        Telefono telefono = Telefono.crear("3001234567");

        assertEquals("3001234567", telefono.obtenerNumero());
    }

    @Test
    void debeAceptarTelefonoConPrefijoColombiano() {

        Telefono telefono = Telefono.crear("+573001234567");

        assertEquals("+573001234567", telefono.obtenerNumero());
    }

    @Test
    void debeNormalizarTelefonoConEspaciosYGuiones() {

        Telefono telefono = Telefono.crear("(+57) 300-123-4567");

        assertEquals("+573001234567", telefono.obtenerNumero());
    }

    @Test
    void noDebeAceptarTelefonoNulo() {

        assertThrows(IllegalArgumentException.class, () -> {
            Telefono.crear(null);
        });
    }

    @Test
    void noDebeAceptarTelefonoVacio() {

        assertThrows(IllegalArgumentException.class, () -> {
            Telefono.crear("");
        });
    }

    @Test
    void noDebeAceptarTelefonoConMenosDeDiezDigitos() {

        assertThrows(IllegalArgumentException.class, () -> {
            Telefono.crear("30012345");
        });
    }

    @Test
    void noDebeAceptarTelefonoConMasDeDiezDigitos() {

        assertThrows(IllegalArgumentException.class, () -> {
            Telefono.crear("300123456789");
        });
    }

    @Test
    void dosTelefonosConElMismoNumeroDebenSerIguales() {

        Telefono telefono1 = Telefono.crear("3001234567");
        Telefono telefono2 = Telefono.crear("3001234567");

        assertEquals(telefono1, telefono2);
        assertEquals(telefono1.hashCode(), telefono2.hashCode());
    }
}
