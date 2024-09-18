package com.aerolinea.aerolinea.dto.Avion.Response;

import lombok.Data;

@Data
public class GetAllResponseDTO {

    private String aviRegistro;

    private int aviCantidadAsientos;

    private String marNombre;

    private String modNombre;

}
