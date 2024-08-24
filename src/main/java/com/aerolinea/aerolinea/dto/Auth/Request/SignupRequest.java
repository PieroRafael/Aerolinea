package com.aerolinea.aerolinea.dto.Auth.Request;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.aerolinea.aerolinea.payload.Auth.UniqueUserEmail;
import com.aerolinea.aerolinea.payload.Auth.UniqueUserNickname;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignupRequest {

    @NotBlank
    @NotNull(message = "Can not be null")
    @Size(min = 5, max = 100)
    @UniqueUserNickname
    private String userNickname;

    @NotBlank
    @NotNull(message = "Can not be null")
    @Size(min = 10, max = 100)
    @Email(message = "The format must be email type")
    @UniqueUserEmail
    private String userEmail;

    @NotBlank
    @NotNull(message = "Can not be null")
    @Size(min = 5, max = 100)
    private String userPassword;

    private Set<String> roles;

}
