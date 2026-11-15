/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cea.infrastructure.repositories;

import com.cea.domain.entities.Ruta;
import com.cea.domain.repositories.RutaRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class InMemoryRutaRepository implements RutaRepository {

    private final Map<UUID, Ruta> rutas = new HashMap<>();

    @Override
    public void guardar(Ruta ruta) {
        if (ruta == null) {
            throw new IllegalArgumentException(
                    "La ruta no puede ser nula."
            );
        }

        rutas.put(ruta.obtenerId(), ruta);
    }

    @Override
    public Optional<Ruta> buscarPorId(UUID id) {
        return Optional.ofNullable(rutas.get(id));
    }

    @Override
    public List<Ruta> listarTodas() {
        return new ArrayList<>(rutas.values());
    }

    @Override
    public void eliminar(UUID id) {
        rutas.remove(id);
    }
}
