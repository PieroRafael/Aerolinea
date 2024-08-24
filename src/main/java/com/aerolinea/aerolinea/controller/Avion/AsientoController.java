package com.aerolinea.aerolinea.controller.Avion;

import com.aerolinea.aerolinea.dto.Asiento.AsientoListDTO;
import com.aerolinea.aerolinea.dto.Asiento.AsientoSaveDTO;
import com.aerolinea.aerolinea.service.Avion.AsientoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<AsientoSaveDTO> Create(@Valid @RequestBody AsientoSaveDTO asientoSaveDTO) {
        AsientoSaveDTO asiento = asientoService.create(asientoSaveDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Message", "Asiento creado correctamente")
                .body(asiento);
    }

    @GetMapping("/GetAll")
    public ResponseEntity<List<AsientoListDTO>> GetAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(asientoService.getAll());
    }

    @PutMapping("/UpdateById/{astId}")
    public ResponseEntity<Void> UpdateById(@PathVariable Long astId, @Valid @RequestBody AsientoSaveDTO asientoSaveDTO) {
        asientoService.updateById(astId, asientoSaveDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/DeleteById/{astId}")
    public ResponseEntity<Void> DeleteById(@PathVariable Long astId) {
        asientoService.deleteById(astId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/DeactivateByAstId/{astId}")
    public ResponseEntity<Void> DeactivateByAstId(@PathVariable Long astId) {
        asientoService.deactivateByAstId(astId);
        return ResponseEntity.status(HttpStatus.OK).
                header("Message","Asiento desactivado correctamente").
                build();
    }

    @PatchMapping("/ActivateByAstId/{astId}")
    public ResponseEntity<Void> ActivateByAstId(@PathVariable Long astId) {
        asientoService.activateByAstId(astId);
        return ResponseEntity.status(HttpStatus.OK).
                header("Message","Asiento activado correctamente").
                build();
    }

    @GetMapping("/GetAllDeactivate")
    public ResponseEntity<List<AsientoListDTO>> GetAllDeactivate() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(asientoService.getAllDeactivate());
    }

    @GetMapping("/GetAllActivated")
    public ResponseEntity<List<AsientoListDTO>> GetAllActivated() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(asientoService.getAllActivated());
    }

}
