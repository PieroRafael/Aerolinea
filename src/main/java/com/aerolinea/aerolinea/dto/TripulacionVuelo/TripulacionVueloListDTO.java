package com.aerolinea.aerolinea.dto.TripulacionVuelo;

import lombok.Data;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
public class TripulacionVueloListDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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

    // PARA UTILIZAR CAMPOS EN UN DTO (LOS CUALES PROVIENEN DE UNA ENTIDAD A OTRA Y OTRA , ECT... (ENTIDADES RELACIONADAS))
    // PODEMOS HACERLO DE VARIAS FORMAS :
    // 1. POR MEDIO DE LOS CAMPOS QUE DESEAMOS MOSTRAR DEFINIENDOLOS DE FORMA DIRECTA
    // ESOS CAMPOS DEBEN DE PERTENCER Y EXISTIR EN CADA UNO DE SUS ENTITYS y DEBE EXISTIR LAS RELACIONES
    // ENTRE ELLOS AH NIVEL DE BDD (EN ESTE DTO ESTAMOS USANDO ESTA TECNICA)
    // 2. POR MEDIO DEL ENTITY (anidamiento de Entitys , esta opcion no brinda seguridad , lo cual no es la mejor)
    // 3. POR MEDIO DE DTOs (Anidamiento de DTOs)

}
