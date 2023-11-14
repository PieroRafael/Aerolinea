package com.aerolinea.aerolinea.dto.CargoTripulante;

import com.aerolinea.aerolinea.payload.CargoTripulante.UniqueCatNombre;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class CargoTripulanteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @NotBlank
    @Size(min = 6 , max = 25)
    @UniqueCatNombre
    private String catNombre;

}
