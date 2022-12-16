package com.aerolinea.aerolinea.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aerolinea.aerolinea.persistence.entity.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Marca m SET m.marStatus = 1 WHERE m.marId = :marId")
    void deactivateByMarId(@Param(value = "marId") Long marId);

    @Transactional
    @Modifying
    @Query("UPDATE Marca m SET m.marStatus = 0 WHERE m.marId = :marId")
    void activateByMarId(@Param(value = "marId") Long marId);

    @Query("SELECT m FROM Marca m WHERE m.marStatus = 1")
    List<Marca> getAllDeactivate();

    @Query("SELECT m FROM Marca m WHERE m.marStatus = 0")
    List<Marca> getAllActivated();

    Optional<Marca> findByMarNombre(String marNombre);

}
