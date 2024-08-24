package com.aerolinea.aerolinea.persistence.repository.Auth;

import com.aerolinea.aerolinea.persistence.entity.Auth.Role;
import com.aerolinea.aerolinea.persistence.entity.Auth.TRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

    Optional<Role> findByName(TRole name);

}
