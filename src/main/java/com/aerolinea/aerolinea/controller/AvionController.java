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

import com.aerolinea.aerolinea.dto.AvionListDTO;
import com.aerolinea.aerolinea.dto.AvionSaveDTO;
import com.aerolinea.aerolinea.service.AvionService;

@RestController
@RequestMapping("/Avion")
public class AvionController {

    private final AvionService avionService;

    public AvionController(AvionService avionService) {
        this.avionService = avionService;
    }

    @PostMapping("/Create")
    public AvionSaveDTO Create(@Valid @RequestBody AvionSaveDTO avionSaveDTO) {
        return avionService.create(avionSaveDTO);
    }

    @GetMapping("/GetAll")
    public List<AvionListDTO> GetAll() {
        return avionService.getAll();
    }

    @PutMapping("/UpdateById/{aviId}")
    public void UpdateById(@RequestParam Long aviId, @Valid @RequestBody AvionSaveDTO avionSaveDTO) {
        avionService.updateById(aviId, avionSaveDTO);
    }

    @DeleteMapping("/DeleteById/{aviId}")
    public void DeleteById(@RequestParam Long aviId) {
        avionService.deleteById(aviId);
    }

    @PatchMapping("/DeactivateByAviId/{aviId}")
    public void DeactivateByAviId(@RequestParam Long aviId) {
        avionService.deactivateByAviId(aviId);
    }

    @PatchMapping("/ActivateByAviId/{aviId}")
    public void ActivateByAviId(@RequestParam Long aviId) {
        avionService.activateByAviId(aviId);
    }

    @GetMapping("/GetAllDeactivate")
    public List<AvionListDTO> GetAllDeactivate() {
        return avionService.getAllDeactivate();
    }

    @GetMapping("/GetAllActivated")
    public List<AvionListDTO> GetAllActivated() {
        return avionService.getAllActivated();
    }

}
