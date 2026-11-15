/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cea.domain.entities;

import com.cea.domain.valueobjects.Jornada;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import com.cea.domain.exceptions.DomainException;
import com.cea.domain.events.RutaDesactivadaEvent;

public class Ruta {

    private final UUID id;
    private String nombre;
    private String barrio;
    private String colegio;
    private Set<Jornada> jornadas;
    private int capacidadMaxima;
    private boolean activa;

    private Ruta(
            String nombre,
            String barrio,
            String colegio,
            Set<Jornada> jornadas,
            int capacidadMaxima) {

        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.barrio = barrio;
        this.colegio = colegio;
        this.jornadas = EnumSet.copyOf(jornadas);
        this.capacidadMaxima = capacidadMaxima;
        this.activa = true;
    }

    public static Ruta crear(
            String nombre,
            String barrio,
            String colegio,
            Set<Jornada> jornadas,
            int capacidadMaxima) {

        validarTexto(nombre, "El nombre de la ruta");
        validarTexto(barrio, "El barrio");
        validarTexto(colegio, "El colegio");
        validarJornadas(jornadas);
        validarCapacidad(capacidadMaxima);

        return new Ruta(
                nombre.trim(),
                barrio.trim(),
                colegio.trim(),
                jornadas,
                capacidadMaxima
        );
    }

    private static void validarTexto(String valor, String campo) {

        if (valor == null || valor.isBlank()) {
            throw new DomainException(
                    campo + " no puede estar vacío."
            );
        }
    }

    private static void validarJornadas(Set<Jornada> jornadas) {

        if (jornadas == null || jornadas.isEmpty()) {
            throw new DomainException(
                    "La ruta debe tener al menos una jornada."
            );
        }

        if (jornadas.contains(null)) {
           throw new DomainException(
                    "La jornada no puede ser nula."
            );
        }
    }

    private static void validarCapacidad(int capacidadMaxima) {

        if (capacidadMaxima < 1 || capacidadMaxima > 10) {
            throw new DomainException(
                    "La capacidad debe estar entre 1 y 10 niños."
            );
        }
    }

    public UUID obtenerId() {
        return id;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerBarrio() {
        return barrio;
    }

    public String obtenerColegio() {
        return colegio;
    }

    public Set<Jornada> obtenerJornadas() {
        return Collections.unmodifiableSet(jornadas);
    }

    public int obtenerCapacidadMaxima() {
        return capacidadMaxima;
    }

    public boolean estaActiva() {
        return activa;
    }

    public void actualizarNombre(String nombre) {
        validarTexto(nombre, "El nombre de la ruta");
        this.nombre = nombre.trim();
    }

    public void actualizarBarrio(String barrio) {
        validarTexto(barrio, "El barrio");
        this.barrio = barrio.trim();
    }

    public void actualizarColegio(String colegio) {
        validarTexto(colegio, "El colegio");
        this.colegio = colegio.trim();
    }

    public void actualizarJornadas(Set<Jornada> jornadas) {
        validarJornadas(jornadas);
        this.jornadas = EnumSet.copyOf(jornadas);
    }

    public void actualizarCapacidadMaxima(int capacidadMaxima) {
        validarCapacidad(capacidadMaxima);
        this.capacidadMaxima = capacidadMaxima;
    }

    public void activar() {
        this.activa = true;
    }

   public RutaDesactivadaEvent desactivar() {
    if (!this.activa) {
        throw new DomainException(
                "La ruta ya se encuentra desactivada."
        );
    }

    this.activa = false;

    return new RutaDesactivadaEvent(this.id);
}

    @Override
    public boolean equals(Object objeto) {

        if (this == objeto) {
            return true;
        }

        if (objeto == null || getClass() != objeto.getClass()) {
            return false;
        }

        Ruta ruta = (Ruta) objeto;

        return Objects.equals(id, ruta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
