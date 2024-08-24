package com.aerolinea.aerolinea.controller.Avion;

import com.aerolinea.aerolinea.dto.TipoAsiento.TipoAsientoDTO;
import com.aerolinea.aerolinea.service.Avion.TipoAsientoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/TipoAsiento")
public class TipoAsientoController {

    private final TipoAsientoService tipoAsientoService;

    public TipoAsientoController(TipoAsientoService tipoAsientoService){
        this.tipoAsientoService = tipoAsientoService;
    }

    @PostMapping("/Create")
    public ResponseEntity<TipoAsientoDTO> Create(@Valid @RequestBody TipoAsientoDTO tipoAsientoDTO){
        TipoAsientoDTO tipoAsiento = tipoAsientoService.create(tipoAsientoDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Message", "TipoAsiento creado correctamente")
                .body(tipoAsiento);
    }

    @GetMapping("/GetAll")
    public ResponseEntity<List<TipoAsientoDTO>> GetAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(tipoAsientoService.getAll());
    }

    @PutMapping("/UpdateById/{tpaId}")
    public ResponseEntity<Void> UpdateById(@PathVariable Long tpaId, @Valid @RequestBody TipoAsientoDTO tipoAsientoDTO) {
        tipoAsientoService.updateById(tpaId, tipoAsientoDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/DeleteById/{tpaId}")
    public ResponseEntity<Void> DeleteById(@PathVariable Long tpaId) {
        tipoAsientoService.deleteById(tpaId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
