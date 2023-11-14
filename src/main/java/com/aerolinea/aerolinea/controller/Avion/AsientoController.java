package com.aerolinea.aerolinea.controller.Avion;

import com.aerolinea.aerolinea.dto.Asiento.AsientoListDTO;
import com.aerolinea.aerolinea.dto.Asiento.AsientoSaveDTO;
import com.aerolinea.aerolinea.dto.Avion.AvionListDTO;
import com.aerolinea.aerolinea.dto.Avion.AvionSaveDTO;
import com.aerolinea.aerolinea.service.Avion.AsientoService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Asiento")
public class AsientoController {

    private final AsientoService asientoService;

    public AsientoController(AsientoService asientoService){
        this.asientoService = asientoService;
    }

    @PostMapping("/Create")
    public AsientoSaveDTO Create(@Valid @RequestBody AsientoSaveDTO asientoSaveDTO) {
        return asientoService.create(asientoSaveDTO);
    }

    @GetMapping("/GetAll")
    public List<AsientoListDTO> GetAll() {
        return asientoService.getAll();
    }

    @PutMapping("/UpdateById/{astId}")
    public void UpdateById(@RequestParam Long astId, @Valid @RequestBody AsientoSaveDTO asientoSaveDTO) {
        asientoService.updateById(astId, asientoSaveDTO);
    }

    @DeleteMapping("/DeleteById/{astId}")
    public void DeleteById(@RequestParam Long astId) {
        asientoService.deleteById(astId);
    }

    @PatchMapping("/DeactivateByAstId/{astId}")
    public void DeactivateByAstId(@RequestParam Long astId) {
        asientoService.deactivateByAstId(astId);
    }

    @PatchMapping("/ActivateByAstId/{astId}")
    public void ActivateByAstId(@RequestParam Long astId) {
        asientoService.activateByAstId(astId);
    }

    @GetMapping("/GetAllDeactivate")
    public List<AsientoListDTO> GetAllDeactivate() {
        return asientoService.getAllDeactivate();
    }

    @GetMapping("/GetAllActivated")
    public List<AsientoListDTO> GetAllActivated() {
        return asientoService.getAllActivated();
    }

}
