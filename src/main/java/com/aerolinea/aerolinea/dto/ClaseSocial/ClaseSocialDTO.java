package com.aerolinea.aerolinea.dto.ClaseSocial;

import com.aerolinea.aerolinea.payload.ClaseSocial.UniqueCslNombre;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class ClaseSocialDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @NotBlank
    @UniqueCslNombre
    private String clsNombre;

}
