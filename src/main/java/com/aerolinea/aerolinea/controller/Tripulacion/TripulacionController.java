package com.aerolinea.aerolinea.controller.Tripulacion;

import com.aerolinea.aerolinea.dto.Tripulacion.Request.TripulacionUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.Tripulacion.Response.TripulacionCreateResponseDTO;
import com.aerolinea.aerolinea.dto.Tripulacion.Response.TripulacionGetAllResponseDTO;
import com.aerolinea.aerolinea.dto.Tripulacion.Request.TripulacionCreateRequestDTO;
import com.aerolinea.aerolinea.service.Tripulacion.TripulacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tripulacion")
public class TripulacionController {

    private final TripulacionService tripulacionService;

    public TripulacionController(TripulacionService tripulacionService){
        this.tripulacionService = tripulacionService;
    }

    @PostMapping("/create")
    public ResponseEntity<TripulacionCreateResponseDTO> create(@Valid @RequestBody TripulacionCreateRequestDTO tripulacionCreateRequestDTO) {
        TripulacionCreateResponseDTO tripulacion = tripulacionService.create(tripulacionCreateRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(tripulacion);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TripulacionGetAllResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(tripulacionService.getAll());
    }

    @PutMapping("/updateById/{triId}")
    public ResponseEntity<Void> updateById(@PathVariable Long triId, @Valid @RequestBody TripulacionUpdateByIdRequestDTO tripulacionUpdateByIdRequestDTO) {
        tripulacionService.updateById(triId, tripulacionUpdateByIdRequestDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteById/{triId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long triId) {
        tripulacionService.deleteById(triId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
