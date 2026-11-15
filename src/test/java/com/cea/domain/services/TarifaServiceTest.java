/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cea.domain.services;

import com.cea.domain.strategies.TarifaConDescuentoStrategy;
import com.cea.domain.strategies.TarifaSinDescuentoStrategy;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TarifaServiceTest {

    private final TarifaService servicio = new TarifaService();

    @Test
    void debeCalcularTarifaSinDescuento() {

        BigDecimal resultado = servicio.calcularTarifa(
                new BigDecimal("200000"),
                new TarifaSinDescuentoStrategy()
        );

        assertEquals(new BigDecimal("200000"), resultado);
    }

    @Test
    void debeCalcularTarifaConDescuento() {

        BigDecimal resultado = servicio.calcularTarifa(
                new BigDecimal("200000"),
                new TarifaConDescuentoStrategy(new BigDecimal("10"))
        );

        assertEquals(new BigDecimal("180000"), resultado);
    }

    @Test
    void noDebeCalcularTarifaSinEstrategia() {

        assertThrows(IllegalArgumentException.class, () ->
                servicio.calcularTarifa(
                        new BigDecimal("200000"),
                        null
                )
        );
    }
}
