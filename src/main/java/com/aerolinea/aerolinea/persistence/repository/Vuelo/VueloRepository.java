package com.aerolinea.aerolinea.persistence.repository.Vuelo;

import com.aerolinea.aerolinea.persistence.entity.Vuelo.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo,Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Vuelo v SET v.vueStatus = 1 WHERE v.vueId = :vueId")
    void deactivateByVueId(@Param(value = "vueId") Long vueId);

    @Transactional
    @Modifying
    @Query("UPDATE Vuelo v SET v.vueStatus = 0 WHERE v.vueId = :vueId")
    void activateByVueId(@Param(value = "vueId") Long vueId);

    @Query("SELECT v FROM Vuelo v WHERE v.vueStatus = 1")
    List<Vuelo> getAllDeactivate();

    @Query("SELECT v FROM Vuelo v WHERE v.vueStatus = 0")
    List<Vuelo> getAllActivated();

}
