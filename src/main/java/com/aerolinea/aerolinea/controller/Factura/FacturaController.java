package com.aerolinea.aerolinea.controller.Factura;

import com.aerolinea.aerolinea.dto.Factura.FacturaListDTO;
import com.aerolinea.aerolinea.dto.Factura.FacturaSaveDTO;
import com.aerolinea.aerolinea.service.Factura.FacturaService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Factura")
public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService){
        this.facturaService = facturaService;
    }

    @PostMapping("/Create")
    public FacturaSaveDTO Create(@Valid @RequestBody FacturaSaveDTO facturaDTO) {
        return facturaService.create(facturaDTO);
    }

    @GetMapping("/GetAll")
    public List<FacturaListDTO> GetAll() {
        return facturaService.getAll();
    }

    @PutMapping("/UpdateById/{facId}")
    public void UpdateById(@RequestParam Long facId, @Valid @RequestBody FacturaSaveDTO facturaDTO) {
        facturaService.updateById(facId, facturaDTO);
    }

    @DeleteMapping("/DeleteById/{facId}")
    public void DeleteById(@RequestParam Long facId) {
        facturaService.deleteById(facId);
    }

}
