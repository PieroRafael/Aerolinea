package com.aerolinea.aerolinea.controller.Avion;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aerolinea.aerolinea.dto.Avion.AvionListDTO;
import com.aerolinea.aerolinea.dto.Avion.AvionSaveDTO;
import com.aerolinea.aerolinea.service.Avion.AvionService;

@RestController
@RequestMapping("/Avion")
public class AvionController {

    private final AvionService avionService;

    public AvionController(AvionService avionService) {
        this.avionService = avionService;
    }

    @PostMapping("/Create")
    public ResponseEntity<AvionSaveDTO> Create(@Valid @RequestBody AvionSaveDTO avionSaveDTO) {
        AvionSaveDTO avion = avionService.create(avionSaveDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Message", "Avion creado correctamente")
                .body(avion);
    }

    @GetMapping("/GetAll")
    public ResponseEntity<List<AvionListDTO>> GetAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(avionService.getAll());
    }

    @PutMapping("/UpdateById/{aviId}")
    public ResponseEntity <Void> UpdateById(@PathVariable Long aviId, @Valid @RequestBody AvionSaveDTO avionSaveDTO) {
        avionService.updateById(aviId, avionSaveDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/DeleteById/{aviId}")
    public ResponseEntity<Void> DeleteById(@PathVariable Long aviId) {
        avionService.deleteById(aviId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/DeactivateByAviId/{aviId}")
    public ResponseEntity<Void> DeactivateByAviId(@PathVariable Long aviId) {
        avionService.deactivateByAviId(aviId);
        return ResponseEntity.status(HttpStatus.OK).
                header("Message","Avion desactivado correctamente").
                build();
    }

    @PatchMapping("/ActivateByAviId/{aviId}")
    public ResponseEntity<Void> ActivateByAviId(@PathVariable Long aviId) {
        avionService.activateByAviId(aviId);
        return ResponseEntity.status(HttpStatus.OK).
                header("Message","Avion activado correctamente").
                build();
    }

    @GetMapping("/GetAllDeactivate")
    public  ResponseEntity<List<AvionListDTO>> GetAllDeactivate() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(avionService.getAllDeactivate());
    }

    @GetMapping("/GetAllActivated")
    public ResponseEntity<List<AvionListDTO>> GetAllActivated() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(avionService.getAllActivated());
    }

}
