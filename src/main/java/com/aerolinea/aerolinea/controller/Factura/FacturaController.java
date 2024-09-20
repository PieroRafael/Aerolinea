package com.aerolinea.aerolinea.controller.Factura;

import com.aerolinea.aerolinea.dto.Factura.Request.FacturaUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.Factura.Response.FacturaGetAllResponseDTO;
import com.aerolinea.aerolinea.dto.Factura.Request.FacturaCreateRequestDTO;
import com.aerolinea.aerolinea.dto.Factura.Response.FacturaCreateResponseDTO;
import com.aerolinea.aerolinea.service.Factura.FacturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/factura")
public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService){
        this.facturaService = facturaService;
    }

    @PostMapping("/create")
    public ResponseEntity<FacturaCreateResponseDTO> create(@Valid @RequestBody FacturaCreateRequestDTO facturaCreateRequestDTO) {
        FacturaCreateResponseDTO factura = facturaService.create(facturaCreateRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(factura);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<FacturaGetAllResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(facturaService.getAll());
    }

    @PutMapping("/updateById/{facId}")
    public ResponseEntity<Void> updateById(@PathVariable Long facId, @Valid @RequestBody FacturaUpdateByIdRequestDTO facturaUpdateByIdRequestDTO) {
        facturaService.updateById(facId, facturaUpdateByIdRequestDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteById/{facId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long facId) {
        facturaService.deleteById(facId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
