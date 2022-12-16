package com.aerolinea.aerolinea.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aerolinea.aerolinea.persistence.entity.Avion;

@Repository
public interface AvionRepository extends JpaRepository<Avion, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Avion a SET a.aviStatus = 1 WHERE a.aviId = :aviId")
    void deactivateByAviId(@Param(value = "aviId") Long aviId);

    @Transactional
    @Modifying
    @Query("UPDATE Avion a SET a.aviStatus = 0 WHERE a.aviId = :aviId")
    void activateByAviId(@Param(value = "aviId") Long aviId);

    @Query("SELECT a FROM Avion a WHERE a.aviStatus = 1")
    List<Avion> getAllDeactivate();

    @Query("SELECT a FROM Avion a WHERE a.aviStatus = 0")
    List<Avion> getAllActivated();

    Optional<Avion> findByAviRegistro(String aviRegistro);

}
