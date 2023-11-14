package com.aerolinea.aerolinea.persistence.repository.Usuario;

import com.aerolinea.aerolinea.persistence.entity.Usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Usuario a SET a.usuStatus = 1 WHERE a.usuId = :usuId")
    void deactivateByUsuId(@Param(value = "usuId") Long usuId);

    @Transactional
    @Modifying
    @Query("UPDATE Usuario a SET a.usuStatus = 0 WHERE a.usuId = :usuId")
    void activateByUsuId(@Param(value = "usuId") Long usuId);

    @Query("SELECT a FROM Usuario a WHERE a.usuStatus = 1")
    List<Usuario> getAllDeactivate();

    @Query("SELECT a FROM Usuario a WHERE a.usuStatus = 0")
    List<Usuario> getAllActivated();

    Optional<Usuario> findByUsuEmail(String usuEmail);

}
