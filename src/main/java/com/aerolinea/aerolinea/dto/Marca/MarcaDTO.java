package com.aerolinea.aerolinea.dto.Marca;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.aerolinea.aerolinea.payload.Marca.UniqueMarNombre;

import lombok.Data;

@Data
public class MarcaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank
    @NotNull
    @Size(min = 5, max = 15)
    @UniqueMarNombre
    private String marNombre;

}
