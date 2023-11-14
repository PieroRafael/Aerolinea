package com.aerolinea.aerolinea.persistence.repository.Avion;

import com.aerolinea.aerolinea.persistence.entity.Avion.TipoAsiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoAsientoRepository extends JpaRepository<TipoAsiento , Long> {

    Optional<TipoAsiento> findByTpaNombre(String tpaNombre);

}
