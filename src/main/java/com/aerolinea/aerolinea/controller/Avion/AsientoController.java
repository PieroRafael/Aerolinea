package com.aerolinea.aerolinea.controller.Avion;

import com.aerolinea.aerolinea.dto.Asiento.Request.AsientoUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.Asiento.Response.AsientoGetAllResponseDTO;
import com.aerolinea.aerolinea.dto.Asiento.Request.AsientoCreateRequestDTO;
import com.aerolinea.aerolinea.dto.Asiento.Response.AsientoCreateResponseDTO;
import com.aerolinea.aerolinea.service.Avion.AsientoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/asiento")
public class AsientoController {

    private final AsientoService asientoService;

    public AsientoController(AsientoService asientoService){
        this.asientoService = asientoService;
    }

    @PostMapping("/create")
    public ResponseEntity<AsientoCreateResponseDTO> create(@Valid @RequestBody AsientoCreateRequestDTO asientoCreateRequestDTO) {
        AsientoCreateResponseDTO asiento = asientoService.create(asientoCreateRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(asiento);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AsientoGetAllResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(asientoService.getAll());
    }

    @PutMapping("/updateById/{astId}")
    public ResponseEntity<Void> updateById(@PathVariable Long astId, @Valid @RequestBody AsientoUpdateByIdRequestDTO asientoUpdateByIdRequestDTO) {
        asientoService.updateById(astId, asientoUpdateByIdRequestDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteById/{astId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long astId) {
        asientoService.deleteById(astId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/deactivateByAstId/{astId}")
    public ResponseEntity<Void> deactivateByAstId(@PathVariable Long astId) {
        asientoService.deactivateByAstId(astId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("/activateByAstId/{astId}")
    public ResponseEntity<Void> activateByAstId(@PathVariable Long astId) {
        asientoService.activateByAstId(astId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/getAllDeactivate")
    public ResponseEntity<List<AsientoGetAllResponseDTO>> getAllDeactivate() {
        return ResponseEntity.status(HttpStatus.OK).body(asientoService.getAllDeactivate());
    }

    @GetMapping("/getAllActivated")
    public ResponseEntity<List<AsientoGetAllResponseDTO>> getAllActivated() {
        return ResponseEntity.status(HttpStatus.OK).body(asientoService.getAllActivated());
    }

}
