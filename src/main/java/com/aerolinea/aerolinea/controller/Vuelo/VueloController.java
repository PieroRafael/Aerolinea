package com.aerolinea.aerolinea.controller.Vuelo;

import com.aerolinea.aerolinea.dto.Vuelo.Request.VueloUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.Vuelo.Response.VueloCreateResponseDTO;
import com.aerolinea.aerolinea.dto.Vuelo.Response.VueloGetAllResponseDTO;
import com.aerolinea.aerolinea.dto.Vuelo.Request.VueloCreateRequestDTO;
import com.aerolinea.aerolinea.service.Vuelo.VueloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/vuelo")
public class VueloController {

    private final VueloService vueloService;

    public VueloController(VueloService vueloService){
        this.vueloService = vueloService;
    }

    @PostMapping("/create")
    public ResponseEntity<VueloCreateResponseDTO> create(@Valid @RequestBody VueloCreateRequestDTO vueloCreateRequestDTO) {
        VueloCreateResponseDTO vuelo = vueloService.create(vueloCreateRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(vuelo);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<VueloGetAllResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(vueloService.getAll());
    }

    @PutMapping("/updateById/{vueId}")
    public ResponseEntity<Void> updateById(@PathVariable Long vueId, @Valid @RequestBody VueloUpdateByIdRequestDTO vueloUpdateByIdRequestDTO) {
        vueloService.updateById(vueId, vueloUpdateByIdRequestDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteById/{vueId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long vueId) {
        vueloService.deleteById(vueId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/deactivateByVueId/{vueId}")
    public ResponseEntity<Void> deactivateByVueId(@PathVariable Long vueId) {
        vueloService.deactivateByVueId(vueId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("/activateByVueId/{vueId}")
    public ResponseEntity<Void> activateByVueId(@PathVariable Long vueId) {
        vueloService.activateByVueId(vueId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/getAllDeactivate")
    public ResponseEntity<List<VueloGetAllResponseDTO>> getAllDeactivate() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(vueloService.getAllDeactivate());
    }

    @GetMapping("/getAllActivated")
    public ResponseEntity<List<VueloGetAllResponseDTO>> getAllActivated() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(vueloService.getAllActivated());
    }

}
