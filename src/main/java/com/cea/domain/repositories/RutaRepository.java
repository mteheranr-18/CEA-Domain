/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cea.domain.repositories;

import com.cea.domain.entities.Ruta;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RutaRepository {

    void guardar(Ruta ruta);

    Optional<Ruta> buscarPorId(UUID id);

    List<Ruta> listarTodas();

    void eliminar(UUID id);
}
