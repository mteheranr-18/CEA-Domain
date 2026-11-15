/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cea.domain.strategies;

import java.math.BigDecimal;

public class TarifaSinDescuentoStrategy implements TarifaStrategy {

    @Override
    public BigDecimal calcular(BigDecimal tarifaBase) {

        if (tarifaBase == null || tarifaBase.signum() < 0) {
            throw new IllegalArgumentException(
                    "La tarifa base no puede ser nula ni negativa."
            );
        }

        return tarifaBase;
    }
}
