package com.aerolinea.aerolinea.controller.Avion;

import java.util.List;

import javax.validation.Valid;

import com.aerolinea.aerolinea.dto.Marca.Request.UpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.Marca.Response.CreateResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aerolinea.aerolinea.dto.Marca.Request.CreateRequestDTO;
import com.aerolinea.aerolinea.service.Avion.MarcaService;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateResponseDTO> create(@Valid @RequestBody CreateRequestDTO createRequestDTO) {
        CreateResponseDTO marca = marcaService.create(createRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(marca);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CreateResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(marcaService.getAll());
    }

    @PutMapping("/updateById/{marId}")
    public ResponseEntity<Void> updateById(@PathVariable Long marId, @Valid @RequestBody UpdateByIdRequestDTO updateByIdRequestDTO) {
        marcaService.updateById(marId, updateByIdRequestDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteById/{marId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long marId) {
        marcaService.deleteById(marId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
