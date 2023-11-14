package com.aerolinea.aerolinea.controller.Tripulacion;

import com.aerolinea.aerolinea.dto.TripulacionVuelo.TripulacionVueloListDTO;
import com.aerolinea.aerolinea.dto.TripulacionVuelo.TripulacionVueloSaveDTO;
import com.aerolinea.aerolinea.service.Tripulacion.TripulacionVueloService;
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
    public TripulacionVueloSaveDTO Create(@Valid @RequestBody TripulacionVueloSaveDTO tripulacionVueloSaveDTO) {
        return tripulacionVueloService.create(tripulacionVueloSaveDTO);
    }

    @GetMapping("/GetAll")
    public List<TripulacionVueloListDTO> GetAll() {
        return tripulacionVueloService.getAll();
    }

    @PutMapping("/UpdateById/{tvuId}")
    public void UpdateById(@RequestParam Long tvuId, @Valid @RequestBody TripulacionVueloSaveDTO tripulacionVueloSaveDTO) {
        tripulacionVueloService.updateById(tvuId, tripulacionVueloSaveDTO);
    }

    @DeleteMapping("/DeleteById/{tvuId}")
    public void DeleteById(@RequestParam Long tvuId) {
        tripulacionVueloService.deleteById(tvuId);
    }

}
