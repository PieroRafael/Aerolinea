package com.aerolinea.aerolinea.dto.Auth.Request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.aerolinea.aerolinea.payload.Auth.ExistPassword;
import com.aerolinea.aerolinea.payload.Auth.ExistUserNickname;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginRequest {

    @NotBlank
    @Size(min = 5, max = 100)
    @ExistUserNickname
    private String userNickname;

    @NotBlank
    @Size(min = 5, max = 100)
    private String userPassword;

}
