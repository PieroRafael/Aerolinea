package com.aerolinea.aerolinea.persistence.repository.Pasajero;

import com.aerolinea.aerolinea.persistence.entity.Pasajero.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero , Long> {

    Optional<Pasajero> findByPasNombre(String pasNombre);

    Optional<Pasajero> findByPasApellido(String pasApellido);

}
