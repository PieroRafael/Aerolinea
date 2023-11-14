package com.aerolinea.aerolinea.persistence.repository.Avion;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aerolinea.aerolinea.persistence.entity.Avion.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    Optional<Modelo> findByModNombre(String modNombre);

}
