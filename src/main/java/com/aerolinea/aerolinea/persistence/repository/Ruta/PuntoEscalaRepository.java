package com.aerolinea.aerolinea.persistence.repository.Ruta;

import com.aerolinea.aerolinea.persistence.entity.Ruta.PuntoEscala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PuntoEscalaRepository extends JpaRepository<PuntoEscala,Long> {

    Optional<PuntoEscala> findByPesNombrePunto(String pesNombrePunto);

}
