package com.aerolinea.aerolinea.controller.Tripulacion;

import com.aerolinea.aerolinea.dto.TripulacionVuelo.Request.TripulacionVueloUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.TripulacionVuelo.Response.TripulacionVueloCreateResponseDTO;
import com.aerolinea.aerolinea.dto.TripulacionVuelo.Response.TripulacionVueloGetAllResponseDTO;
import com.aerolinea.aerolinea.dto.TripulacionVuelo.Request.TripulacionVueloCreateRequestDTO;
import com.aerolinea.aerolinea.service.Tripulacion.TripulacionVueloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tripulacionVuelo")
public class TripulacionVueloController {

    private final TripulacionVueloService tripulacionVueloService;

    public TripulacionVueloController(TripulacionVueloService tripulacionVueloService){
        this.tripulacionVueloService = tripulacionVueloService;
    }

    @PostMapping("/create")
    public ResponseEntity<TripulacionVueloCreateResponseDTO> create(@Valid @RequestBody TripulacionVueloCreateRequestDTO tripulacionVueloCreateRequestDTO) {
        TripulacionVueloCreateResponseDTO tripulacionVuelo = tripulacionVueloService.create(tripulacionVueloCreateRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(tripulacionVuelo);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TripulacionVueloGetAllResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(tripulacionVueloService.getAll());
    }

    @PutMapping("/updateById/{tvuId}")
    public ResponseEntity<Void> updateById(@PathVariable Long tvuId, @Valid @RequestBody TripulacionVueloUpdateByIdRequestDTO tripulacionVueloUpdateByIdRequestDTO) {
        tripulacionVueloService.updateById(tvuId, tripulacionVueloUpdateByIdRequestDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteById/{tvuId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long tvuId) {
        tripulacionVueloService.deleteById(tvuId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
