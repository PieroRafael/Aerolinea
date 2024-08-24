package com.aerolinea.aerolinea.controller.Ruta;

import com.aerolinea.aerolinea.dto.Ruta.RutaDTO;
import com.aerolinea.aerolinea.service.Ruta.RutaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Ruta")
public class RutaController {

    private final RutaService rutaService;

    public RutaController(RutaService rutaService){
        this.rutaService = rutaService;
    }

    @PostMapping("/Create")
    public ResponseEntity<RutaDTO> Create(@Valid @RequestBody RutaDTO rutaDTO){
        RutaDTO ruta = rutaService.create(rutaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Message", "Ruta creado correctamente")
                .body(ruta);
    }

    @GetMapping("/GetAll")
    public ResponseEntity<List<RutaDTO>> GetAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(rutaService.getAll());
    }

    @PutMapping("/UpdateById/{rtaId}")
    public ResponseEntity<Void> UpdateById(@PathVariable Long rtaId, @Valid @RequestBody RutaDTO rutaDTO) {
        rutaService.updateById(rtaId, rutaDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/DeleteById/{rtaId}")
    public ResponseEntity<Void> DeleteById(@PathVariable Long rtaId) {
        rutaService.deleteById(rtaId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
