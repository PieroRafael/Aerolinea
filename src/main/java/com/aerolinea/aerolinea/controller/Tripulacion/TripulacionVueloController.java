package com.aerolinea.aerolinea.controller.Tripulacion;

import com.aerolinea.aerolinea.dto.TripulacionVuelo.TripulacionVueloListDTO;
import com.aerolinea.aerolinea.dto.TripulacionVuelo.TripulacionVueloSaveDTO;
import com.aerolinea.aerolinea.service.Tripulacion.TripulacionVueloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/TripulacionVuelo")
public class TripulacionVueloController {

    private final TripulacionVueloService tripulacionVueloService;

    public TripulacionVueloController(TripulacionVueloService tripulacionVueloService){
        this.tripulacionVueloService = tripulacionVueloService;
    }

    @PostMapping("/Create")
    public ResponseEntity<TripulacionVueloSaveDTO> Create(@Valid @RequestBody TripulacionVueloSaveDTO tripulacionVueloSaveDTO) {
        TripulacionVueloSaveDTO tripulacionVuelo = tripulacionVueloService.create(tripulacionVueloSaveDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Message", "TripulacionVuelo creado correctamente")
                .body(tripulacionVuelo);
    }

    @GetMapping("/GetAll")
    public ResponseEntity<List<TripulacionVueloListDTO>> GetAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(tripulacionVueloService.getAll());
    }

    @PutMapping("/UpdateById/{tvuId}")
    public ResponseEntity<Void> UpdateById(@PathVariable Long tvuId, @Valid @RequestBody TripulacionVueloSaveDTO tripulacionVueloSaveDTO) {
        tripulacionVueloService.updateById(tvuId, tripulacionVueloSaveDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/DeleteById/{tvuId}")
    public ResponseEntity<Void> DeleteById(@PathVariable Long tvuId) {
        tripulacionVueloService.deleteById(tvuId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
