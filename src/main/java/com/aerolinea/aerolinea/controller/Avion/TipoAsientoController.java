package com.aerolinea.aerolinea.controller.Avion;

import com.aerolinea.aerolinea.dto.TipoAsiento.TipoAsientoDTO;
import com.aerolinea.aerolinea.service.Avion.TipoAsientoService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/TipoAsiento")
public class TipoAsientoController {

    private final TipoAsientoService tipoAsientoService;

    public TipoAsientoController(TipoAsientoService tipoAsientoService){
        this.tipoAsientoService = tipoAsientoService;
    }

    @PostMapping("/Create")
    public TipoAsientoDTO Create(@Valid @RequestBody TipoAsientoDTO tipoAsientoDTO){
        return tipoAsientoService.create(tipoAsientoDTO);
    }

    @GetMapping("/GetAll")
    public List<TipoAsientoDTO> GetAll() {
        return tipoAsientoService.getAll();
    }

    @PutMapping("/UpdateById/{tpaId}")
    public void UpdateById(@RequestParam Long tpaId, @Valid @RequestBody TipoAsientoDTO tipoAsientoDTO) {
        tipoAsientoService.updateById(tpaId, tipoAsientoDTO);
    }

    @DeleteMapping("/DeleteById/{tpaId}")
    public void DeleteById(@RequestParam Long tpaId) {
        tipoAsientoService.deleteById(tpaId);
    }

}
