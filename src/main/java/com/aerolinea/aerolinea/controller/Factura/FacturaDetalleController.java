package com.aerolinea.aerolinea.controller.Factura;

import com.aerolinea.aerolinea.dto.FacturaDetalle.FacturaDetalleListDTO;
import com.aerolinea.aerolinea.dto.FacturaDetalle.FacturaDetalleSaveDTO;
import com.aerolinea.aerolinea.service.Factura.FacturaDetalleService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/FacturaDetalle")
public class FacturaDetalleController {

    private final FacturaDetalleService facturaDetalleService;

    public FacturaDetalleController(FacturaDetalleService facturaDetalleService){
        this.facturaDetalleService = facturaDetalleService;
    }

    @PostMapping("/Create")
    public FacturaDetalleSaveDTO Create(@Valid @RequestBody FacturaDetalleSaveDTO facturaDetalleSaveDTO) {
        return facturaDetalleService.create(facturaDetalleSaveDTO);
    }

    @GetMapping("/GetAll")
    public List<FacturaDetalleListDTO> GetAll() {
        return facturaDetalleService.getAll();
    }

    @PutMapping("/UpdateById/{fadId}")
    public void UpdateById(@RequestParam Long fadId, @Valid @RequestBody FacturaDetalleSaveDTO facturaDetalleSaveDTO) {
        facturaDetalleService.updateById(fadId, facturaDetalleSaveDTO);
    }

    @DeleteMapping("/DeleteById/{fadId}")
    public void DeleteById(@RequestParam Long fadId) {
        facturaDetalleService.deleteById(fadId);
    }

}
