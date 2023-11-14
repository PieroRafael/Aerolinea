package com.aerolinea.aerolinea.controller.Ruta;

import com.aerolinea.aerolinea.dto.PuntoEscala.PuntoEscalaDTO;
import com.aerolinea.aerolinea.service.Ruta.PuntoEscalaService;
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
    public PuntoEscalaDTO Create(@Valid @RequestBody PuntoEscalaDTO puntoEscalaDTO){
        return puntoEscalaService.create(puntoEscalaDTO);
    }

    @GetMapping("/GetAll")
    public List<PuntoEscalaDTO> GetAll() {
        return puntoEscalaService.getAll();
    }

    @PutMapping("/UpdateById/{pesId}")
    public void UpdateById(@RequestParam Long pesId, @Valid @RequestBody PuntoEscalaDTO puntoEscalaDTO) {
        puntoEscalaService.updateById(pesId, puntoEscalaDTO);
    }

    @DeleteMapping("/DeleteById/{pesId}")
    public void DeleteById(@RequestParam Long pesId) {
        puntoEscalaService.deleteById(pesId);
    }

}
