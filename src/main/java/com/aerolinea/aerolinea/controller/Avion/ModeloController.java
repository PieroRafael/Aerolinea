package com.aerolinea.aerolinea.controller.Avion;

import java.util.List;

import javax.validation.Valid;

import com.aerolinea.aerolinea.dto.Modelo.Request.UpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.Modelo.Response.CreateResponseDTO;
import com.aerolinea.aerolinea.dto.Modelo.Response.GetAllResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aerolinea.aerolinea.dto.Modelo.Request.CreateRequestDTO;
import com.aerolinea.aerolinea.service.Avion.ModeloService;

@RestController
@RequestMapping("/modelo")
public class ModeloController {

    private final ModeloService modeloService;

    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateResponseDTO> create(@Valid @RequestBody CreateRequestDTO createRequestDTO) {
        CreateResponseDTO modelo = modeloService.create(createRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelo);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<GetAllResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(modeloService.getAll());
    }

    @PutMapping("/updateById/{modId}")
    public ResponseEntity<Void> updateById(@PathVariable Long modId, @Valid @RequestBody UpdateByIdRequestDTO updateByIdRequestDTO) {
        modeloService.updateById(modId, updateByIdRequestDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteById/{modId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long modId) {
        modeloService.deleteById(modId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
