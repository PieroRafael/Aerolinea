package com.aerolinea.aerolinea.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aerolinea.aerolinea.persistence.entity.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Modelo m SET m.modStatus = 1 WHERE m.modId = :modId")
    void deactivateByModId(@Param(value = "modId") Long modId);

    @Transactional
    @Modifying
    @Query("UPDATE Modelo m SET m.modStatus = 0 WHERE m.modId = :modId")
    void activateByModId(@Param(value = "modId") Long modId);

    @Query("SELECT m FROM Modelo m WHERE m.modStatus = 1")
    List<Modelo> getAllDeactivate();

    @Query("SELECT m FROM Modelo m WHERE m.modStatus = 0")
    List<Modelo> getAllActivated();

    Optional<Modelo> findByModNombre(String modNombre);

}
