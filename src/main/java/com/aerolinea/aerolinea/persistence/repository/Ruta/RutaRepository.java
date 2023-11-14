package com.aerolinea.aerolinea.persistence.repository.Ruta;

import com.aerolinea.aerolinea.persistence.entity.Ruta.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RutaRepository extends JpaRepository<Ruta , Long> {

    Optional<Ruta> findByRtaNombre(String rtaNombre);

}
