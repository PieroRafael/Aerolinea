package com.aerolinea.aerolinea.persistence.repository.Tripulacion;

import com.aerolinea.aerolinea.persistence.entity.Tripulacion.Tripulacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TripulacionRepository extends JpaRepository<Tripulacion,Long> {

    public Optional<Tripulacion> findByTriNombre(String triNombre);

    public Optional<Tripulacion> findByTriApellido(String triApellido);

}
