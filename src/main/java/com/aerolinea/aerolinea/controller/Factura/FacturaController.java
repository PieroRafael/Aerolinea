package com.aerolinea.aerolinea.controller.Factura;

import com.aerolinea.aerolinea.dto.Factura.FacturaListDTO;
import com.aerolinea.aerolinea.dto.Factura.FacturaSaveDTO;
import com.aerolinea.aerolinea.service.Factura.FacturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<FacturaSaveDTO> Create(@Valid @RequestBody FacturaSaveDTO facturaDTO) {
        FacturaSaveDTO factura = facturaService.create(facturaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Message", "Factura creado correctamente")
                .body(factura);
    }

    @GetMapping("/GetAll")
    public ResponseEntity<List<FacturaListDTO>> GetAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(facturaService.getAll());
    }

    @PutMapping("/UpdateById/{facId}")
    public ResponseEntity<Void> UpdateById(@PathVariable Long facId, @Valid @RequestBody FacturaSaveDTO facturaDTO) {
        facturaService.updateById(facId, facturaDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/DeleteById/{facId}")
    public ResponseEntity<Void> DeleteById(@PathVariable Long facId) {
        facturaService.deleteById(facId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
