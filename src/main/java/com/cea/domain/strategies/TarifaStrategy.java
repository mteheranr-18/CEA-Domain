/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cea.domain.strategies;

import java.math.BigDecimal;

public interface TarifaStrategy {

    BigDecimal calcular(BigDecimal tarifaBase);
}
