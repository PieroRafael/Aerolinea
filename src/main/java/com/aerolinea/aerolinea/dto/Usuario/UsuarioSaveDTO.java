package com.aerolinea.aerolinea.dto.Usuario;

import com.aerolinea.aerolinea.payload.Usuario.FKTipoUsuario;
import com.aerolinea.aerolinea.payload.Usuario.UniqueTpuId;
import com.aerolinea.aerolinea.payload.Usuario.UniqueUsuEmail;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class UsuarioSaveDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @NotBlank
    @Size(min = 15, max = 50)
    @UniqueUsuEmail
    private String usuEmail;

    @NotNull
    @NotBlank
    @Size(min = 5, max = 30)
    private String usuContraseña;

    @NotNull
    @FKTipoUsuario
    @UniqueTpuId
    private Long tpuId;

}
