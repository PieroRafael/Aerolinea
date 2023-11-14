package com.aerolinea.aerolinea.controller.Tripulacion;

import com.aerolinea.aerolinea.dto.Tripulacion.TripulacionListDTO;
import com.aerolinea.aerolinea.dto.Tripulacion.TripulacionSaveDTO;
import com.aerolinea.aerolinea.service.Tripulacion.TripulacionService;
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
    public TripulacionSaveDTO Create(@Valid @RequestBody TripulacionSaveDTO tripulacionSaveDTO) {
        return tripulacionService.create(tripulacionSaveDTO);
    }

    @GetMapping("/GetAll")
    public List<TripulacionListDTO> GetAll() {
        return tripulacionService.getAll();
    }

    @PutMapping("/UpdateById/{triId}")
    public void UpdateById(@RequestParam Long triId, @Valid @RequestBody TripulacionSaveDTO tripulacionSaveDTO) {
        tripulacionService.updateById(triId, tripulacionSaveDTO);
    }

    @DeleteMapping("/DeleteById/{triId}")
    public void DeleteById(@RequestParam Long triId) {
        tripulacionService.deleteById(triId);
    }

}
