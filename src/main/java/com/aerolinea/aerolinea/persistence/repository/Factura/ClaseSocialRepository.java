package com.aerolinea.aerolinea.persistence.repository.Factura;

import com.aerolinea.aerolinea.persistence.entity.Factura.ClaseSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClaseSocialRepository extends JpaRepository<ClaseSocial , Long> {

    public Optional<ClaseSocial> findByClsNombre(String clsNombre);

}
