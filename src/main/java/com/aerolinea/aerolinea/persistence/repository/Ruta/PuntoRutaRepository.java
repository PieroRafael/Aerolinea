package com.aerolinea.aerolinea.persistence.repository.Ruta;

import com.aerolinea.aerolinea.persistence.entity.Ruta.PuntoEscala;
import com.aerolinea.aerolinea.persistence.entity.Ruta.PuntoRuta;
import com.aerolinea.aerolinea.persistence.entity.Ruta.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PuntoRutaRepository extends JpaRepository<PuntoRuta,Long> {

    Optional<PuntoRuta> findByPtrOrden(String ptrOrden);

    Optional<PuntoRuta> findByRutaAndPuntoEscala(Ruta ruta , PuntoEscala puntoEscala);

}
