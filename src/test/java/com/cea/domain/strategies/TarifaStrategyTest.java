/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cea.domain.strategies;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TarifaStrategyTest {

    @Test
    void debeCalcularTarifaSinDescuento() {

        TarifaStrategy estrategia =
                new TarifaSinDescuentoStrategy();

        BigDecimal resultado =
                estrategia.calcular(new BigDecimal("200000"));

        assertEquals(new BigDecimal("200000"), resultado);
    }

    @Test
    void debeCalcularTarifaConDescuento() {

        TarifaStrategy estrategia =
                new TarifaConDescuentoStrategy(new BigDecimal("10"));

        BigDecimal resultado =
                estrategia.calcular(new BigDecimal("200000"));

        assertEquals(new BigDecimal("180000"), resultado);
    }

    @Test
    void noDebePermitirDescuentoSuperiorAlCienPorCiento() {

        assertThrows(IllegalArgumentException.class, () ->
                new TarifaConDescuentoStrategy(new BigDecimal("110"))
        );
    }

    @Test
    void noDebePermitirTarifaNegativa() {

        TarifaStrategy estrategia =
                new TarifaSinDescuentoStrategy();

        assertThrows(IllegalArgumentException.class, () ->
                estrategia.calcular(new BigDecimal("-50000"))
        );
    }

    @Test
    void debePermitirTarifaSinDescuentoCuandoElPorcentajeEsCero() {

        TarifaStrategy estrategia =
                new TarifaConDescuentoStrategy(BigDecimal.ZERO);

        assertEquals(
                new BigDecimal("200000"),
                estrategia.calcular(new BigDecimal("200000"))
        );
    }
}
