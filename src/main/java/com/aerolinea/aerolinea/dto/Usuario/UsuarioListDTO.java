package com.aerolinea.aerolinea.dto.Usuario;

import lombok.Data;

import java.io.Serializable;

@Data
public class UsuarioListDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String usuEmail;

    private String tpuNombre;

}
