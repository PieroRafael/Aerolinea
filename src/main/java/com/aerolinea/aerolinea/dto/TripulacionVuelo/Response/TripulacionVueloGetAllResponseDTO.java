package com.aerolinea.aerolinea.dto.TripulacionVuelo.Response;
import lombok.Data;
import java.time.ZonedDateTime;

@Data
public class TripulacionVueloGetAllResponseDTO {

    // Tripulacion

    private String triNombre;

    private String triApellido;

    private String triCodigo;

    // CargoTripulante

    private String catNombre;

    // Vuelo

    private String vueCod;

    private ZonedDateTime vueFHPartida;

    private ZonedDateTime vueFHLlegada;

    // Avion

    private String aviRegistro;

    // Ruta;

    private String rtaNombre;

}
