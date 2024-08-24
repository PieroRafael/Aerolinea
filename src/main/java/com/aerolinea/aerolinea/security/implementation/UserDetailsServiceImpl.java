package com.aerolinea.aerolinea.security.implementation;

import com.aerolinea.aerolinea.persistence.entity.Auth.Users;
import com.aerolinea.aerolinea.persistence.repository.Auth.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsersRepository userRepository;

    public UserDetailsServiceImpl (UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userNickname) throws UsernameNotFoundException {
        Users user = userRepository.findByUserNickname(userNickname)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with User Nickname: " + userNickname));

        return UserDetailsImpl.build(user);
    }

}
