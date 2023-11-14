package com.aerolinea.aerolinea.dto.Tripulacion;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class TripulacionListDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String triNombre;

    private String triApellido;

    private UUID triCodigo;

    private String catNombre;

}
