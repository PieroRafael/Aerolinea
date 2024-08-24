package com.aerolinea.aerolinea.controller.Ruta;

import com.aerolinea.aerolinea.dto.PuntoEscala.PuntoEscalaDTO;
import com.aerolinea.aerolinea.service.Ruta.PuntoEscalaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/PuntoEscala")
public class PuntoEscalaController {

    private final PuntoEscalaService puntoEscalaService;

    public PuntoEscalaController(PuntoEscalaService puntoEscalaService){
        this.puntoEscalaService = puntoEscalaService;
    }

    @PostMapping("/Create")
    public ResponseEntity<PuntoEscalaDTO> Create(@Valid @RequestBody PuntoEscalaDTO puntoEscalaDTO){
        PuntoEscalaDTO puntoEscala = puntoEscalaService.create(puntoEscalaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Message", "PuntoEscala creado correctamente")
                .body(puntoEscala);
    }

    @GetMapping("/GetAll")
    public ResponseEntity<List<PuntoEscalaDTO>> GetAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(puntoEscalaService.getAll());
    }

    @PutMapping("/UpdateById/{pesId}")
    public ResponseEntity<Void> UpdateById(@PathVariable Long pesId, @Valid @RequestBody PuntoEscalaDTO puntoEscalaDTO) {
        puntoEscalaService.updateById(pesId, puntoEscalaDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/DeleteById/{pesId}")
    public ResponseEntity<Void> DeleteById(@PathVariable Long pesId) {
        puntoEscalaService.deleteById(pesId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
