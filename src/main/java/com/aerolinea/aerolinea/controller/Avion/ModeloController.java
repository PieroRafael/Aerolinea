package com.aerolinea.aerolinea.controller.Avion;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ModeloDTO Create(@Valid @RequestBody ModeloDTO modeloDTO) {
        return modeloService.create(modeloDTO);
    }

    @GetMapping("/GetAll")
    public List<ModeloDTO> GetAll() {
        return modeloService.getAll();
    }


    @PutMapping("/UpdateById/{modId}")
    public void UpdateById(@RequestParam Long modId, @Valid @RequestBody ModeloDTO modeloDTO) {
        modeloService.updateById(modId, modeloDTO);
    }

    @DeleteMapping("/DeleteById/{modId}")
    public void DeleteById(@RequestParam Long modId) {
        modeloService.deleteById(modId);
    }

}
