package com.aerolinea.aerolinea.controller.Tripulacion;

import com.aerolinea.aerolinea.dto.Tripulacion.TripulacionListDTO;
import com.aerolinea.aerolinea.dto.Tripulacion.TripulacionSaveDTO;
import com.aerolinea.aerolinea.service.Tripulacion.TripulacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Tripulacion")
public class TripulacionController {

    private final TripulacionService tripulacionService;

    public TripulacionController(TripulacionService tripulacionService){
        this.tripulacionService = tripulacionService;
    }

    @PostMapping("/Create")
    public ResponseEntity<TripulacionSaveDTO> Create(@Valid @RequestBody TripulacionSaveDTO tripulacionSaveDTO) {
        TripulacionSaveDTO tripulacion = tripulacionService.create(tripulacionSaveDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Message", "Tripulacion creado correctamente")
                .body(tripulacion);
    }

    @GetMapping("/GetAll")
    public ResponseEntity<List<TripulacionListDTO>> GetAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(tripulacionService.getAll());
    }

    @PutMapping("/UpdateById/{triId}")
    public ResponseEntity<Void> UpdateById(@PathVariable Long triId, @Valid @RequestBody TripulacionSaveDTO tripulacionSaveDTO) {
        tripulacionService.updateById(triId, tripulacionSaveDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/DeleteById/{triId}")
    public ResponseEntity<Void> DeleteById(@PathVariable Long triId) {
        tripulacionService.deleteById(triId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
