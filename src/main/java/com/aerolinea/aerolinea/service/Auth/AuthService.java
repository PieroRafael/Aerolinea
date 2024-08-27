package com.aerolinea.aerolinea.service.Auth;

import com.aerolinea.aerolinea.dto.Auth.Request.LoginRequest;
import com.aerolinea.aerolinea.dto.Auth.Request.SignupRequest;
import com.aerolinea.aerolinea.dto.Auth.Response.JwtResponse;
import com.aerolinea.aerolinea.dto.Auth.Response.MessageResponse;
import com.aerolinea.aerolinea.exception.custom.InvalidPasswordException;
import com.aerolinea.aerolinea.exception.custom.ResourceNotFoundException;
import com.aerolinea.aerolinea.persistence.entity.Auth.Role;
import com.aerolinea.aerolinea.persistence.entity.Auth.TRole;
import com.aerolinea.aerolinea.persistence.entity.Auth.Users;
import com.aerolinea.aerolinea.persistence.repository.Auth.RoleRepository;
import com.aerolinea.aerolinea.persistence.repository.Auth.UsersRepository;
import com.aerolinea.aerolinea.security.implementation.UserDetailsImpl;
import com.aerolinea.aerolinea.security.jwt.JwtUtils;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthService {

    private final UsersRepository userRepository;
    private final RoleRepository roleRepository;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder encoder;
    private final ModelMapper modelMapper;

    public AuthService (AuthenticationManager authenticationManager, UsersRepository userRepository,
                           RoleRepository roleRepository, PasswordEncoder encoder, JwtUtils jwtUtils,
                           ModelMapper modelMapper) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
        this.modelMapper = modelMapper;
    }

    public MessageResponse registerUser(SignupRequest signupRequest) {
        // Create new user's account
        Users user = new Users(
                signupRequest.getUserEmail(),
                signupRequest.getUserNickname(),
                encoder.encode(signupRequest.getUserPassword()
                ));
        // Define Rol Object (Collection)
        Set<String> strRoles = signupRequest.getRoles();
        Set<Role> roles = new HashSet<>();
        // Verify and Assign Rol
        for (String role : strRoles) {
            switch (role) {
                case "ROLE_ADMIN" -> {
                    Role adminRoleCMS = roleRepository.findByName(TRole.ROLE_ADMIN).orElseThrow(() -> new ResourceNotFoundException("Error : ROLE_ADMIN is not found"));
                    roles.add(adminRoleCMS);
                }
                case "ROLE_USER" -> {
                    Role userRoleCMS = roleRepository.findByName(TRole.ROLE_USER).orElseThrow(() -> new ResourceNotFoundException("Error: ROLE_USER is not found"));
                    roles.add(userRoleCMS);
                }
                case "" -> {
                    Role NullRole = roleRepository.findByName(TRole.ROLE_USER).orElseThrow(() -> new ResourceNotFoundException("Error : ROLE_USER is not found"));
                    roles.add(NullRole);
                }
                default -> throw new ResourceNotFoundException("Error: INVALID ROLE provided.");
            }
        }
        // Save Rol
        user.setRoles(roles);
        // Save All Data User
        return modelMapper.map(userRepository.save(user),MessageResponse.class);
    }

    public JwtResponse authenticateUser(LoginRequest loginRequest) {
        Users user = userRepository.findByUserNickname(loginRequest.getUserNickname()).orElseThrow(
                () -> new ResourceNotFoundException("User Not Found With UserNickname")
        );
        if (!encoder.matches(loginRequest.getUserPassword(), user.getUserPassword())) {
            throw new InvalidPasswordException("Password Incorrect");
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserNickname(),
                        loginRequest.getUserPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return new JwtResponse(jwt, "Bearer", userDetails.getUserId(), userDetails.getUserNickname(),
                        userDetails.getUserEmail(), userDetails.getUserPhoto(),roles);
    }

}
