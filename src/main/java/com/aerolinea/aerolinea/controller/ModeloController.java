package com.aerolinea.aerolinea.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aerolinea.aerolinea.dto.ModeloDTO;
import com.aerolinea.aerolinea.service.ModeloService;

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

    @PatchMapping("/DeactivateByModId/{modId}")
    public void DeactivateByModId(@RequestParam Long modId) {
        modeloService.deactivateByModId(modId);
    }

    @PatchMapping("/ActivateByModId/{modId}")
    public void ActivateByModId(@RequestParam Long modId) {
        modeloService.activateByModId(modId);
    }

    @GetMapping("/GetAllDeactivate")
    public List<ModeloDTO> GetAllDeactivate() {
        return modeloService.getAllDeactivate();
    }

    @GetMapping("/GetAllActivated")
    public List<ModeloDTO> GetAllActivated() {
        return modeloService.getAllActivated();
    }

}
