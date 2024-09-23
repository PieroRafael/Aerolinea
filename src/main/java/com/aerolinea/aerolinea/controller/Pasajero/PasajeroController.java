package com.aerolinea.aerolinea.controller.Pasajero;

import com.aerolinea.aerolinea.dto.Pasajero.Request.PasajeroCreateRequestDTO;
import com.aerolinea.aerolinea.dto.Pasajero.Request.PasajeroUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.Pasajero.Response.PasajeroCreateResponseDTO;
import com.aerolinea.aerolinea.dto.Pasajero.Response.PasajeroGetAllResponseDTO;
import com.aerolinea.aerolinea.service.Pasajero.PasajeroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pasajero")
public class PasajeroController {

    private final PasajeroService pasajeroService;

    public PasajeroController(PasajeroService pasajeroService){
        this.pasajeroService = pasajeroService;
    }

    @PostMapping("/create")
    public ResponseEntity<PasajeroCreateResponseDTO> create(@Valid @RequestBody PasajeroCreateRequestDTO pasajeroCreateRequestDTO) {
        PasajeroCreateResponseDTO pasajero = pasajeroService.create(pasajeroCreateRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pasajero);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PasajeroGetAllResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(pasajeroService.getAll());
    }

    @PutMapping("/updateById/{pasId}")
    public ResponseEntity<Void> updateById(@PathVariable Long pasId, @Valid @RequestBody PasajeroUpdateByIdRequestDTO pasajeroUpdateByIdRequestDTO) {
        pasajeroService.updateById(pasId, pasajeroUpdateByIdRequestDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteById/{pasId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long pasId) {
        pasajeroService.deleteById(pasId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
