package com.aerolinea.aerolinea.persistence.repository.Auth;

import com.aerolinea.aerolinea.persistence.entity.Auth.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository  extends JpaRepository<Users, UUID> {

    Optional<Users> findByUserEmail(String userEmail);

    Optional<Users> findByUserNickname(String userNickname);

}
