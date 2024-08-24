package com.aerolinea.aerolinea.controller.Avion;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aerolinea.aerolinea.dto.Marca.MarcaDTO;
import com.aerolinea.aerolinea.service.Avion.MarcaService;

@RestController
@RequestMapping("/Marca")
public class MarcaController {

    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @PostMapping("/Create")
    public ResponseEntity<MarcaDTO> Create(@Valid @RequestBody MarcaDTO marcaDTO) {
        MarcaDTO marca = marcaService.create(marcaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Message", "Marca creado correctamente")
                .body(marca);
    }

    @GetMapping("/GetAll")
    public ResponseEntity<List<MarcaDTO>> GetAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(marcaService.getAll());
    }

    @PutMapping("/UpdateById/{marId}")
    public ResponseEntity<Void> UpdateById(@PathVariable Long marId, @Valid @RequestBody MarcaDTO marcaDTO) {
        marcaService.updateById(marId, marcaDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/DeleteById/{marId}")
    public ResponseEntity<Void> DeleteById(@PathVariable Long marId) {
        marcaService.deleteById(marId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
