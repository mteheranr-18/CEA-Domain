/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cea.domain.valueobjects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JornadaTest {

    @Test
    void debeExistirLaJornadaManana() {
        assertEquals(Jornada.MANANA, Jornada.valueOf("MANANA"));
    }

    @Test
    void debeExistirLaJornadaMediodia() {
        assertEquals(Jornada.MEDIODIA, Jornada.valueOf("MEDIODIA"));
    }

    @Test
    void debeExistirLaJornadaTarde() {
        assertEquals(Jornada.TARDE, Jornada.valueOf("TARDE"));
    }

    @Test
    void debeContenerTresJornadas() {
        assertEquals(3, Jornada.values().length);
    }
}
