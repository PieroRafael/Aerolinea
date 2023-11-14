package com.aerolinea.aerolinea.persistence.repository.Avion;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.aerolinea.aerolinea.persistence.entity.Avion.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

    Optional<Marca> findByMarNombre(String marNombre);

}
