package com.aerolinea.aerolinea.persistence.repository.Avion;

import com.aerolinea.aerolinea.persistence.entity.Avion.Asiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface AsientoRepository extends JpaRepository<Asiento , Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Asiento a SET a.astStatus = 1 WHERE a.astId = :astId")
    void deactivateByAstId(@Param(value = "astId") Long astId);

    @Transactional
    @Modifying
    @Query("UPDATE Asiento a SET a.astStatus = 0 WHERE a.astId = :astId")
    void activateByAstId(@Param(value = "astId") Long astId);

    @Query("SELECT a FROM Asiento a WHERE a.astStatus = 1")
    List<Asiento> getAllDeactivate();

    @Query("SELECT a FROM Asiento a WHERE a.astStatus = 0")
    List<Asiento> getAllActivated();

    Optional<Asiento> findByAstNombre(String astNombre);

}
