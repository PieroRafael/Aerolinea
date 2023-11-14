package com.aerolinea.aerolinea.persistence.repository.Usuario;

import com.aerolinea.aerolinea.persistence.entity.Usuario.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario,Long> {

    Optional<TipoUsuario> findByTpuNombre(String tpuNombre);

}
