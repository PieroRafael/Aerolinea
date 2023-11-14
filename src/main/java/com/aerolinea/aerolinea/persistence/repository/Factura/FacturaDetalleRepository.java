package com.aerolinea.aerolinea.persistence.repository.Factura;

import com.aerolinea.aerolinea.persistence.entity.Factura.FacturaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaDetalleRepository extends JpaRepository<FacturaDetalle,Long> {

}
