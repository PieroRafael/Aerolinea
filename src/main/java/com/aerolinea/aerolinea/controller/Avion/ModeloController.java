package com.aerolinea.aerolinea.controller.Avion;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aerolinea.aerolinea.dto.Modelo.ModeloDTO;
import com.aerolinea.aerolinea.service.Avion.ModeloService;

@RestController
@RequestMapping("/Modelo")
public class ModeloController {

    private final ModeloService modeloService;

    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @PostMapping("/Create")
    public ResponseEntity<ModeloDTO> Create(@Valid @RequestBody ModeloDTO modeloDTO) {
        ModeloDTO modelo = modeloService.create(modeloDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Message", "Modelo creado correctamente")
                .body(modelo);
    }

    @GetMapping("/GetAll")
    public ResponseEntity<List<ModeloDTO>>  GetAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(modeloService.getAll());
    }


    @PutMapping("/UpdateById/{modId}")
    public ResponseEntity<Void> UpdateById(@PathVariable Long modId, @Valid @RequestBody ModeloDTO modeloDTO) {
        modeloService.updateById(modId, modeloDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/DeleteById/{modId}")
    public ResponseEntity<Void>  DeleteById(@PathVariable Long modId) {
        modeloService.deleteById(modId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
