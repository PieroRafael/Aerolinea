package com.aerolinea.aerolinea.dto.Auth;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class RoleDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String roleId;

    @NotBlank(message = "Can not be blank")
    @NotNull(message = "Can not be null")
    @Size(min = 11, max = 20, message = "The size should be between 11 to 20")
    private String name;

}
