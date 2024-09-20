package com.aerolinea.aerolinea.controller.Avion;

import com.aerolinea.aerolinea.dto.TipoAsiento.Request.TipoAsientoCreateRequestDTO;
import com.aerolinea.aerolinea.dto.TipoAsiento.Request.TipoAsientoUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.TipoAsiento.Response.TipoAsientoCreateResponseDTO;
import com.aerolinea.aerolinea.dto.TipoAsiento.Response.TipoAsientoGetAllResponseDTO;
import com.aerolinea.aerolinea.service.Avion.TipoAsientoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tipoAsiento")
public class TipoAsientoController {

    private final TipoAsientoService tipoAsientoService;

    public TipoAsientoController(TipoAsientoService tipoAsientoService){
        this.tipoAsientoService = tipoAsientoService;
    }

    @PostMapping("/create")
    public ResponseEntity<TipoAsientoCreateResponseDTO> create(@Valid @RequestBody TipoAsientoCreateRequestDTO tipoAsientoDTO){
        TipoAsientoCreateResponseDTO tipoAsiento = tipoAsientoService.create(tipoAsientoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoAsiento);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TipoAsientoGetAllResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(tipoAsientoService.getAll());
    }

    @PutMapping("/updateById/{tpaId}")
    public ResponseEntity<Void> updateById(@PathVariable Long tpaId, @Valid @RequestBody TipoAsientoUpdateByIdRequestDTO tipoAsientoUpdateByIdRequestDTO) {
        tipoAsientoService.updateById(tpaId, tipoAsientoUpdateByIdRequestDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteById/{tpaId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long tpaId) {
        tipoAsientoService.deleteById(tpaId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
