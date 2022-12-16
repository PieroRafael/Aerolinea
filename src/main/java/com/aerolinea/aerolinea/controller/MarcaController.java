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

import com.aerolinea.aerolinea.dto.MarcaDTO;
import com.aerolinea.aerolinea.service.MarcaService;

@RestController
@RequestMapping("/Marca")
public class MarcaController {

    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @PostMapping("/Create")
    public MarcaDTO Create(@Valid @RequestBody MarcaDTO marcaDTO) {
        return marcaService.create(marcaDTO);
    }

    @GetMapping("/GetAll")
    public List<MarcaDTO> GetAll() {
        return marcaService.getAll();
    }

    @PutMapping("/UpdateById/{marId}")
    public void UpdateById(@RequestParam Long marId, @Valid @RequestBody MarcaDTO marcaDTO) {
        marcaService.updateById(marId, marcaDTO);
    }

    @DeleteMapping("/DeleteById/{marId}")
    public void DeleteById(@RequestParam Long marId) {
        marcaService.deleteById(marId);
    }

    @PatchMapping("/DeactivateByMarId/{marId}")
    public void DeactivateByMarId(@RequestParam Long marId) {
        marcaService.deactivateByMarId(marId);
    }

    @PatchMapping("/ActivateByMarId/{marId}")
    public void ActivateByMarId(@RequestParam Long marId) {
        marcaService.activateByMarId(marId);
    }

    @GetMapping("/GetAllDeactivate")
    public List<MarcaDTO> GetAllDeactivate() {
        return marcaService.getAllDeactivate();
    }

    @GetMapping("/GetAllActivated")
    public List<MarcaDTO> GetAllActivated() {
        return marcaService.getAllActivated();
    }

}
