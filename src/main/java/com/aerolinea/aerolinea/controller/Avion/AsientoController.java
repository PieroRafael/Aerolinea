package com.aerolinea.aerolinea.controller.Avion;

import com.aerolinea.aerolinea.dto.Asiento.Request.UpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.Asiento.Response.GetAllResponseDTO;
import com.aerolinea.aerolinea.dto.Asiento.Request.CreateRequestDTO;
import com.aerolinea.aerolinea.dto.Asiento.Response.CreateResponseDTO;
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
    public ResponseEntity<CreateResponseDTO> create(@Valid @RequestBody CreateRequestDTO createRequestDTO) {
        CreateResponseDTO asiento = asientoService.create(createRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(asiento);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<GetAllResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(asientoService.getAll());
    }

    @PutMapping("/updateById/{astId}")
    public ResponseEntity<Void> updateById(@PathVariable Long astId, @Valid @RequestBody UpdateByIdRequestDTO updateByIdRequestDTO) {
        asientoService.updateById(astId, updateByIdRequestDTO);
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
    public ResponseEntity<List<GetAllResponseDTO>> getAllDeactivate() {
        return ResponseEntity.status(HttpStatus.OK).body(asientoService.getAllDeactivate());
    }

    @GetMapping("/getAllActivated")
    public ResponseEntity<List<GetAllResponseDTO>> getAllActivated() {
        return ResponseEntity.status(HttpStatus.OK).body(asientoService.getAllActivated());
    }

}
