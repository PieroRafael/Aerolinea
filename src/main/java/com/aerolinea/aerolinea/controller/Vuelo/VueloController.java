package com.aerolinea.aerolinea.controller.Vuelo;

import com.aerolinea.aerolinea.dto.Vuelo.VueloListDTO;
import com.aerolinea.aerolinea.dto.Vuelo.VueloSaveDTO;
import com.aerolinea.aerolinea.service.Vuelo.VueloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<VueloSaveDTO> Create(@Valid @RequestBody VueloSaveDTO vueloSaveDTO) {
        VueloSaveDTO vuelo = vueloService.create(vueloSaveDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Message", "Vuelo creado correctamente")
                .body(vuelo);
    }

    @GetMapping("/GetAll")
    public ResponseEntity<List<VueloListDTO>> GetAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(vueloService.getAll());
    }

    @PutMapping("/UpdateById/{vueId}")
    public ResponseEntity<Void> UpdateById(@RequestParam Long vueId, @Valid @RequestBody VueloSaveDTO vueloSaveDTO) {
        vueloService.updateById(vueId, vueloSaveDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/DeleteById/{vueId}")
    public ResponseEntity<Void> DeleteById(@RequestParam Long vueId) {
        vueloService.deleteById(vueId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/DeactivateByVueId/{vueId}")
    public ResponseEntity<Void> DeactivateByVueId(@RequestParam Long vueId) {
        vueloService.deactivateByVueId(vueId);
        return ResponseEntity.status(HttpStatus.OK).
                header("Message","Vuelo desactivado correctamente").
                build();
    }

    @PatchMapping("/ActivateByVueId/{vueId}")
    public ResponseEntity<Void> ActivateByVueId(@RequestParam Long vueId) {
        vueloService.activateByVueId(vueId);
        return ResponseEntity.status(HttpStatus.OK).
                header("Message","Vuelo activado correctamente").
                build();
    }

    @GetMapping("/GetAllDeactivate")
    public ResponseEntity<List<VueloListDTO>> GetAllDeactivate() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(vueloService.getAllDeactivate());
    }

    @GetMapping("/GetAllActivated")
    public ResponseEntity<List<VueloListDTO>> GetAllActivated() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(vueloService.getAllActivated());
    }

}
