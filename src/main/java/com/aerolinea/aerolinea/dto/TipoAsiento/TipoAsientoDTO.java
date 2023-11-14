package com.aerolinea.aerolinea.dto.TipoAsiento;

import com.aerolinea.aerolinea.payload.TipoAsiento.UniqueTpaNombre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoAsientoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank
    @NotNull
    @Size(min =  5, max = 15)
    @UniqueTpaNombre
    private String tpaNombre;

}
