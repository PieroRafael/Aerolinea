package com.aerolinea.aerolinea.controller.Avion;

import com.aerolinea.aerolinea.dto.TipoAsiento.Request.CreateRequestDTO;
import com.aerolinea.aerolinea.dto.TipoAsiento.Request.UpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.TipoAsiento.Response.CreateResponseDTO;
import com.aerolinea.aerolinea.dto.TipoAsiento.Response.GetAllResponseDTO;
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
    public ResponseEntity<CreateResponseDTO> create(@Valid @RequestBody CreateRequestDTO tipoAsientoDTO){
        CreateResponseDTO tipoAsiento = tipoAsientoService.create(tipoAsientoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoAsiento);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<GetAllResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(tipoAsientoService.getAll());
    }

    @PutMapping("/updateById/{tpaId}")
    public ResponseEntity<Void> updateById(@PathVariable Long tpaId, @Valid @RequestBody UpdateByIdRequestDTO updateByIdRequestDTO) {
        tipoAsientoService.updateById(tpaId, updateByIdRequestDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteById/{tpaId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long tpaId) {
        tipoAsientoService.deleteById(tpaId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
