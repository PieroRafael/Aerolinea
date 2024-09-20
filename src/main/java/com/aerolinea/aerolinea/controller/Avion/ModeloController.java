package com.aerolinea.aerolinea.controller.Avion;

import java.util.List;

import javax.validation.Valid;

import com.aerolinea.aerolinea.dto.Modelo.Request.ModeloUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.Modelo.Response.ModeloCreateResponseDTO;
import com.aerolinea.aerolinea.dto.Modelo.Response.ModeloGetAllResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aerolinea.aerolinea.dto.Modelo.Request.ModeloCreateRequestDTO;
import com.aerolinea.aerolinea.service.Avion.ModeloService;

@RestController
@RequestMapping("/modelo")
public class ModeloController {

    private final ModeloService modeloService;

    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @PostMapping("/create")
    public ResponseEntity<ModeloCreateResponseDTO> create(@Valid @RequestBody ModeloCreateRequestDTO modeloCreateRequestDTO) {
        ModeloCreateResponseDTO modelo = modeloService.create(modeloCreateRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelo);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ModeloGetAllResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(modeloService.getAll());
    }

    @PutMapping("/updateById/{modId}")
    public ResponseEntity<Void> updateById(@PathVariable Long modId, @Valid @RequestBody ModeloUpdateByIdRequestDTO modeloUpdateByIdRequestDTO) {
        modeloService.updateById(modId, modeloUpdateByIdRequestDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteById/{modId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long modId) {
        modeloService.deleteById(modId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
