package com.aerolinea.aerolinea.persistence.repository.Tripulacion;

import com.aerolinea.aerolinea.persistence.entity.Tripulacion.TripulacionVuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripulacionVueloRepository extends JpaRepository<TripulacionVuelo,Long> {

}
