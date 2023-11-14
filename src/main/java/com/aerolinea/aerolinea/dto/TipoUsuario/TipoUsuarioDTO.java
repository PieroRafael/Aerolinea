package com.aerolinea.aerolinea.dto.TipoUsuario;

import com.aerolinea.aerolinea.payload.TipoUsuario.UniqueTpuNombre;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class TipoUsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank
    @NotNull
    @Size(min = 5, max = 15)
    @UniqueTpuNombre
    private String tpuNombre;

}
