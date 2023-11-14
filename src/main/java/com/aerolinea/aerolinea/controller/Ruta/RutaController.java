package com.aerolinea.aerolinea.controller.Ruta;

import com.aerolinea.aerolinea.dto.Ruta.RutaDTO;
import com.aerolinea.aerolinea.service.Ruta.RutaService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Ruta")
public class RutaController {

    private final RutaService rutaService;

    public RutaController(RutaService rutaService){
        this.rutaService = rutaService;
    }

    @PostMapping("/Create")
    public RutaDTO Create(@Valid @RequestBody RutaDTO rutaDTO){
        return rutaService.create(rutaDTO);
    }

    @GetMapping("/GetAll")
    public List<RutaDTO> GetAll() {
        return rutaService.getAll();
    }

    @PutMapping("/UpdateById/{rtaId}")
    public void UpdateById(@RequestParam Long rtaId, @Valid @RequestBody RutaDTO rutaDTO) {
        rutaService.updateById(rtaId, rutaDTO);
    }

    @DeleteMapping("/DeleteById/{rtaId}")
    public void DeleteById(@RequestParam Long rtaId) {
        rutaService.deleteById(rtaId);
    }

}
