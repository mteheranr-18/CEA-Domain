/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cea.domain.valueobjects;

import java.util.Objects;

public final class Telefono {

    private final String numero;

    private Telefono(String numero) {
        this.numero = numero;
    }

    public static Telefono crear(String numero) {

        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException(
                "El número telefónico no puede estar vacío."
            );
        }

        String numeroNormalizado = numero.replaceAll("[\\s()-]", "");

        if (!numeroNormalizado.matches("^(\\+57)?\\d{10}$")) {
            throw new IllegalArgumentException(
                "El número telefónico debe tener 10 dígitos "
                + "y puede incluir el prefijo +57."
            );
        }

        return new Telefono(numeroNormalizado);
    }

    public String obtenerNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object objeto) {

        if (this == objeto) {
            return true;
        }

        if (objeto == null || getClass() != objeto.getClass()) {
            return false;
        }

        Telefono telefono = (Telefono) objeto;

        return Objects.equals(numero, telefono.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public String toString() {
        return numero;
    }
}
