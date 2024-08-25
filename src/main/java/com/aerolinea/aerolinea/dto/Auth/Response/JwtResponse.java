package com.aerolinea.aerolinea.dto.Auth.Response;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private UUID userId;
    private String userNickname;
    private String userEmail;
    private String userPhoto;
    private List<String> roles;

}
