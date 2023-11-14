package com.aerolinea.aerolinea.controller.Ruta;

import com.aerolinea.aerolinea.dto.PuntoRuta.PuntoRutaListDTO;
import com.aerolinea.aerolinea.dto.PuntoRuta.PuntoRutaSaveDTO;
import com.aerolinea.aerolinea.service.Ruta.PuntoRutaService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/PuntoRuta")
public class PuntoRutaController {

    private final PuntoRutaService puntoRutaService;

    public PuntoRutaController(PuntoRutaService puntoRutaService){
        this.puntoRutaService = puntoRutaService;
    }

    @PostMapping("/Create")
    public PuntoRutaSaveDTO Create(@Valid @RequestBody PuntoRutaSaveDTO puntoRutaSaveDTO){
        return puntoRutaService.create(puntoRutaSaveDTO);
    }

    @GetMapping("/GetAll")
    public List<PuntoRutaListDTO> GetAll() {
        return puntoRutaService.getAll();
    }

    @PutMapping("/UpdateById/{ptrId}")
    public void UpdateById(@RequestParam Long ptrId, @Valid @RequestBody PuntoRutaSaveDTO puntoRutaSaveDTO) {
        puntoRutaService.updateById(ptrId, puntoRutaSaveDTO);
    }

    @DeleteMapping("/DeleteById/{ptrId}")
    public void DeleteById(@RequestParam Long ptrId) {
        puntoRutaService.deleteById(ptrId);
    }

}
