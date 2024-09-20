package com.aerolinea.aerolinea.controller.Avion;

import java.util.List;

import javax.validation.Valid;

import com.aerolinea.aerolinea.dto.Marca.Request.MarcaUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.Marca.Response.MarcaCreateResponseDTO;
import com.aerolinea.aerolinea.dto.Marca.Response.MarcaGetAllResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aerolinea.aerolinea.dto.Marca.Request.MarcaCreateRequestDTO;
import com.aerolinea.aerolinea.service.Avion.MarcaService;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @PostMapping("/create")
    public ResponseEntity<MarcaCreateResponseDTO> create(@Valid @RequestBody MarcaCreateRequestDTO marcaCreateRequestDTO) {
        MarcaCreateResponseDTO marca = marcaService.create(marcaCreateRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(marca);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<MarcaGetAllResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(marcaService.getAll());
    }

    @PutMapping("/updateById/{marId}")
    public ResponseEntity<Void> updateById(@PathVariable Long marId, @Valid @RequestBody MarcaUpdateByIdRequestDTO marcaUpdateByIdRequestDTO) {
        marcaService.updateById(marId, marcaUpdateByIdRequestDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteById/{marId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long marId) {
        marcaService.deleteById(marId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
