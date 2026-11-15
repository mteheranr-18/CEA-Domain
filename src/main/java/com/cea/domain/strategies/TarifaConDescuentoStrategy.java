/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cea.domain.strategies;

import java.math.BigDecimal;

public class TarifaConDescuentoStrategy implements TarifaStrategy {

    private final BigDecimal porcentajeDescuento;

    public TarifaConDescuentoStrategy(BigDecimal porcentajeDescuento) {

        if (porcentajeDescuento == null
                || porcentajeDescuento.compareTo(BigDecimal.ZERO) < 0
                || porcentajeDescuento.compareTo(new BigDecimal("100")) > 0) {

            throw new IllegalArgumentException(
                    "El descuento debe estar entre 0 y 100."
            );
        }

        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public BigDecimal calcular(BigDecimal tarifaBase) {

        if (tarifaBase == null || tarifaBase.signum() < 0) {
            throw new IllegalArgumentException(
                    "La tarifa base no puede ser nula ni negativa."
            );
        }

        BigDecimal descuento = tarifaBase
                .multiply(porcentajeDescuento)
                .divide(new BigDecimal("100"));

        return tarifaBase.subtract(descuento);
    }
}
