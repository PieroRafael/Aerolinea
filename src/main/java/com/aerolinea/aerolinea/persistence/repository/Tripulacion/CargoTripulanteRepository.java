package com.aerolinea.aerolinea.persistence.repository.Tripulacion;

import com.aerolinea.aerolinea.persistence.entity.Tripulacion.CargoTripulante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CargoTripulanteRepository extends JpaRepository<CargoTripulante,Long> {

    public Optional<CargoTripulante> findByCatNombre(String catNombre);

}
