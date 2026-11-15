/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cea.domain.entities;

import com.cea.domain.valueobjects.Telefono;
import java.util.Objects;
import java.util.UUID;

public class Estudiante {

    private final UUID id;
    private String nombre;
    private Telefono telefono;

    private Estudiante(String nombre, Telefono telefono) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public static Estudiante crear(String nombre, Telefono telefono) {

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                "El nombre del estudiante no puede estar vacío."
            );
        }

        if (telefono == null) {
            throw new IllegalArgumentException(
                "El teléfono del estudiante es obligatorio."
            );
        }

        return new Estudiante(nombre.trim(), telefono);
    }

    public UUID obtenerId() {
        return id;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public Telefono obtenerTelefono() {
        return telefono;
    }

    public void actualizarNombre(String nombre) {

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException(
                "El nombre del estudiante no puede estar vacío."
            );
        }

        this.nombre = nombre.trim();
    }

    public void actualizarTelefono(Telefono telefono) {

        if (telefono == null) {
            throw new IllegalArgumentException(
                "El teléfono del estudiante es obligatorio."
            );
        }

        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object objeto) {

        if (this == objeto) {
            return true;
        }

        if (objeto == null || getClass() != objeto.getClass()) {
            return false;
        }

        Estudiante estudiante = (Estudiante) objeto;

        return Objects.equals(id, estudiante.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
