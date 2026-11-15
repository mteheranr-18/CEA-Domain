/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cea.domain.services;

import com.cea.domain.strategies.TarifaStrategy;
import java.math.BigDecimal;

public class TarifaService {

    public BigDecimal calcularTarifa(
            BigDecimal tarifaBase,
            TarifaStrategy estrategia) {

        if (estrategia == null) {
            throw new IllegalArgumentException(
                    "La estrategia de tarifa es obligatoria."
            );
        }

        return estrategia.calcular(tarifaBase);
    }
}
