package com.aerolinea.aerolinea.persistence.repository.Factura;

import com.aerolinea.aerolinea.persistence.entity.Factura.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura , Long> {



}
