package com.aerolinea.aerolinea.controller.Auth;

import com.aerolinea.aerolinea.dto.Auth.Request.SignupRequest;
import com.aerolinea.aerolinea.dto.Auth.Response.MessageResponse;
import com.aerolinea.aerolinea.service.Auth.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/Auth")
public class AuthController {

    private final AuthService authService;

    public AuthController (AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/RegisterUser")
    public ResponseEntity<MessageResponse> RegisterUser(@Valid @RequestBody SignupRequest signupRequest) {
        authService.registerUser(signupRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageResponse());
    }

}
