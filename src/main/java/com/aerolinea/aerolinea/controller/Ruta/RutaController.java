package com.aerolinea.aerolinea.controller.Ruta;

import com.aerolinea.aerolinea.dto.Ruta.Request.RutaCreateRequestDTO;
import com.aerolinea.aerolinea.dto.Ruta.Request.RutaUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.Ruta.Response.RutaCreateResponseDTO;
import com.aerolinea.aerolinea.dto.Ruta.Response.RutaGetAllResponseDTO;
import com.aerolinea.aerolinea.service.Ruta.RutaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ruta")
public class RutaController {

    private final RutaService rutaService;

    public RutaController(RutaService rutaService){
        this.rutaService = rutaService;
    }

    @PostMapping("/create")
    public ResponseEntity<RutaCreateResponseDTO> create(@Valid @RequestBody RutaCreateRequestDTO rutaCreateRequestDTO){
        RutaCreateResponseDTO ruta = rutaService.create(rutaCreateRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ruta);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<RutaGetAllResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(rutaService.getAll());
    }

    @PutMapping("/updateById/{rtaId}")
    public ResponseEntity<Void> updateById(@PathVariable Long rtaId, @Valid @RequestBody RutaUpdateByIdRequestDTO rutaUpdateByIdRequestDTO) {
        rutaService.updateById(rtaId, rutaUpdateByIdRequestDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteById/{rtaId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long rtaId) {
        rutaService.deleteById(rtaId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
