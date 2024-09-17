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
@RequestMapping("/avion")
public class AvionController {

    private final AvionService avionService;

    public AvionController(AvionService avionService) {
        this.avionService = avionService;
    }

    @PostMapping("/create")
    public ResponseEntity<AvionSaveDTO> create(@Valid @RequestBody AvionSaveDTO avionSaveDTO) {
        AvionSaveDTO avion = avionService.create(avionSaveDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(avion);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AvionListDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(avionService.getAll());
    }

    @PutMapping("/updateById/{aviId}")
    public ResponseEntity <Void> updateById(@PathVariable Long aviId, @Valid @RequestBody AvionSaveDTO avionSaveDTO) {
        avionService.updateById(aviId, avionSaveDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteById/{aviId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long aviId) {
        avionService.deleteById(aviId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/deactivateByAviId/{aviId}")
    public ResponseEntity<Void> deactivateByAviId(@PathVariable Long aviId) {
        avionService.deactivateByAviId(aviId);
        return ResponseEntity.status(HttpStatus.OK).
                header("Message","Avion desactivado correctamente").
                build();
    }

    @PatchMapping("/activateByAviId/{aviId}")
    public ResponseEntity<Void> activateByAviId(@PathVariable Long aviId) {
        avionService.activateByAviId(aviId);
        return ResponseEntity.status(HttpStatus.OK).
                header("Message","Avion activado correctamente").
                build();
    }

    @GetMapping("/getAllDeactivate")
    public  ResponseEntity<List<AvionListDTO>> getAllDeactivate() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(avionService.getAllDeactivate());
    }

    @GetMapping("/getAllActivated")
    public ResponseEntity<List<AvionListDTO>> getAllActivated() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(avionService.getAllActivated());
    }

}
