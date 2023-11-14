package com.aerolinea.aerolinea.dto.Pasajero;

import com.aerolinea.aerolinea.payload.Pasajero.UniquePasApellido;
import com.aerolinea.aerolinea.payload.Pasajero.UniquePasNombre;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
public class PasajeroDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @NotBlank
    @UniquePasNombre
    private String pasNombre;

    @NotNull
    @NotBlank
    @UniquePasApellido
    private String pasApellido;

    @NotNull
    @Positive
    @Min(1)
    @Max(120)
    private int pasEdad;

    @NotNull
    @Pattern(regexp = "^(MASCULINO|FEMENINO)$", flags = Pattern.Flag.CASE_INSENSITIVE, message = "El género debe ser 'MASCULINO' o 'FEMENINO'")
    private String pasGenero;

}
