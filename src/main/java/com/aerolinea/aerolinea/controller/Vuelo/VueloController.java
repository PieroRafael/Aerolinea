package com.aerolinea.aerolinea.controller.Vuelo;

import com.aerolinea.aerolinea.dto.Vuelo.VueloListDTO;
import com.aerolinea.aerolinea.dto.Vuelo.VueloSaveDTO;
import com.aerolinea.aerolinea.service.Vuelo.VueloService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Vuelo")
public class VueloController {

    private final VueloService vueloService;

    public VueloController(VueloService vueloService){
        this.vueloService = vueloService;
    }

    @PostMapping("/Create")
    public VueloSaveDTO Create(@Valid @RequestBody VueloSaveDTO vueloSaveDTO) {
        return vueloService.create(vueloSaveDTO);
    }

    @GetMapping("/GetAll")
    public List<VueloListDTO> GetAll() {
        return vueloService.getAll();
    }

    @PutMapping("/UpdateById/{vueId}")
    public void UpdateById(@RequestParam Long vueId, @Valid @RequestBody VueloSaveDTO vueloSaveDTO) {
        vueloService.updateById(vueId, vueloSaveDTO);
    }

    @DeleteMapping("/DeleteById/{vueId}")
    public void DeleteById(@RequestParam Long vueId) {
        vueloService.deleteById(vueId);
    }

    @PatchMapping("/DeactivateByVueId/{vueId}")
    public void DeactivateByVueId(@RequestParam Long vueId) {
        vueloService.deactivateByVueId(vueId);
    }

    @PatchMapping("/ActivateByVueId/{vueId}")
    public void ActivateByVueId(@RequestParam Long vueId) {
        vueloService.activateByVueId(vueId);
    }

    @GetMapping("/GetAllDeactivate")
    public List<VueloListDTO> GetAllDeactivate() {
        return vueloService.getAllDeactivate();
    }

    @GetMapping("/GetAllActivated")
    public List<VueloListDTO> GetAllActivated() {
        return vueloService.getAllActivated();
    }

}
