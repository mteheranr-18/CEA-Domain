/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cea.domain.exceptions;

public class DomainException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;

    public DomainException(String mensaje) {
        super(mensaje);
    }
}
