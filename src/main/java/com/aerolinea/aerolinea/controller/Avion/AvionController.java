package com.aerolinea.aerolinea.controller.Avion;

import java.util.List;

import javax.validation.Valid;

import com.aerolinea.aerolinea.dto.Avion.Request.AvionUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.Avion.Response.AvionCreateResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aerolinea.aerolinea.dto.Avion.Response.AvionGetAllResponseDTO;
import com.aerolinea.aerolinea.dto.Avion.Request.AvionCreateRequestDTO;
import com.aerolinea.aerolinea.service.Avion.AvionService;

@RestController
@RequestMapping("/avion")
public class AvionController {

    private final AvionService avionService;

    public AvionController(AvionService avionService) {
        this.avionService = avionService;
    }

    @PostMapping("/create")
    public ResponseEntity<AvionCreateResponseDTO> create(@Valid @RequestBody AvionCreateRequestDTO avionCreateRequestDTO) {
        AvionCreateResponseDTO avion = avionService.create(avionCreateRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(avion);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AvionGetAllResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(avionService.getAll());
    }

    @PutMapping("/updateById/{aviId}")
    public ResponseEntity <Void> updateById(@PathVariable Long aviId, @Valid @RequestBody AvionUpdateByIdRequestDTO avionUpdateByIdRequestDTO) {
        avionService.updateById(aviId, avionUpdateByIdRequestDTO);
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
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("/activateByAviId/{aviId}")
    public ResponseEntity<Void> activateByAviId(@PathVariable Long aviId) {
        avionService.activateByAviId(aviId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/getAllDeactivate")
    public  ResponseEntity<List<AvionGetAllResponseDTO>> getAllDeactivate() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(avionService.getAllDeactivate());
    }

    @GetMapping("/getAllActivated")
    public ResponseEntity<List<AvionGetAllResponseDTO>> getAllActivated() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(avionService.getAllActivated());
    }

}
