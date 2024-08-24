package com.aerolinea.aerolinea.controller.Factura;

import com.aerolinea.aerolinea.dto.FacturaDetalle.FacturaDetalleListDTO;
import com.aerolinea.aerolinea.dto.FacturaDetalle.FacturaDetalleSaveDTO;
import com.aerolinea.aerolinea.service.Factura.FacturaDetalleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<FacturaDetalleSaveDTO >Create(@Valid @RequestBody FacturaDetalleSaveDTO facturaDetalleSaveDTO) {
        FacturaDetalleSaveDTO facturaDetalle = facturaDetalleService.create(facturaDetalleSaveDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Message", "FacturaDetalle creado correctamente")
                .body(facturaDetalle);
    }

    @GetMapping("/GetAll")
    public ResponseEntity<List<FacturaDetalleListDTO>> GetAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(facturaDetalleService.getAll());
    }

    @PutMapping("/UpdateById/{fadId}")
    public ResponseEntity<Void> UpdateById(@PathVariable Long fadId, @Valid @RequestBody FacturaDetalleSaveDTO facturaDetalleSaveDTO) {
        facturaDetalleService.updateById(fadId, facturaDetalleSaveDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/DeleteById/{fadId}")
    public ResponseEntity<Void> DeleteById(@PathVariable Long fadId) {
        facturaDetalleService.deleteById(fadId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
