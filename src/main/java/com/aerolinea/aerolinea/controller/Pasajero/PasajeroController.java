package com.aerolinea.aerolinea.controller.Pasajero;

import com.aerolinea.aerolinea.dto.Pasajero.PasajeroDTO;
import com.aerolinea.aerolinea.service.Pasajero.PasajeroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Pasajero")
public class PasajeroController {

    private final PasajeroService pasajeroService;

    public PasajeroController(PasajeroService pasajeroService){
        this.pasajeroService = pasajeroService;
    }

    @PostMapping("/Create")
    public ResponseEntity<PasajeroDTO> Create(@Valid @RequestBody PasajeroDTO pasajeroDTO) {
        PasajeroDTO pasajero = pasajeroService.create(pasajeroDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Message", "Pasajero creado correctamente")
                .body(pasajero);
    }

    @GetMapping("/GetAll")
    public ResponseEntity<List<PasajeroDTO>> GetAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(pasajeroService.getAll());
    }

    @PutMapping("/UpdateById/{pasId}")
    public ResponseEntity<Void> UpdateById(@PathVariable Long pasId, @Valid @RequestBody PasajeroDTO pasajeroDTO) {
        pasajeroService.updateById(pasId, pasajeroDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/DeleteById/{pasId}")
    public ResponseEntity<Void> DeleteById(@PathVariable Long pasId) {
        pasajeroService.deleteById(pasId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
