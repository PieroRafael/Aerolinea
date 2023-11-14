package com.aerolinea.aerolinea.controller.Pasajero;

import com.aerolinea.aerolinea.dto.Pasajero.PasajeroDTO;
import com.aerolinea.aerolinea.service.Pasajero.PasajeroService;
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
    public PasajeroDTO Create(@Valid @RequestBody PasajeroDTO pasajeroDTO) {
        return pasajeroService.create(pasajeroDTO);
    }

    @GetMapping("/GetAll")
    public List<PasajeroDTO> GetAll() {
        return pasajeroService.getAll();
    }

    @PutMapping("/UpdateById/{pasId}")
    public void UpdateById(@RequestParam Long pasId, @Valid @RequestBody PasajeroDTO pasajeroDTO) {
        pasajeroService.updateById(pasId, pasajeroDTO);
    }

    @DeleteMapping("/DeleteById/{pasId}")
    public void DeleteById(@RequestParam Long pasId) {
        pasajeroService.deleteById(pasId);
    }

}
