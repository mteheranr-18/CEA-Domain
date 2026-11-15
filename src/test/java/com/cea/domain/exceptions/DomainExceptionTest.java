/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cea.domain.exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DomainExceptionTest {

    @Test
    void debeCrearUnaExcepcionConMensaje() {

        DomainException excepcion = new DomainException(
                "La capacidad de la ruta no es válida."
        );

        assertEquals(
                "La capacidad de la ruta no es válida.",
                excepcion.getMessage()
        );
    }

    @Test
    void debeSerUnaExcepcionDeArgumentoIlegal() {

        DomainException excepcion = new DomainException(
                "Error de dominio."
        );

        assertTrue(excepcion instanceof IllegalArgumentException);
    }
}
