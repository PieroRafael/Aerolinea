package com.aerolinea.aerolinea.controller.Factura;

import com.aerolinea.aerolinea.dto.FacturaDetalle.Request.FacturaDetalleUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.FacturaDetalle.Response.FacturaDetalleGetAllResponseDTO;
import com.aerolinea.aerolinea.dto.FacturaDetalle.Request.FacturaDetalleCreateRequestDTO;
import com.aerolinea.aerolinea.dto.FacturaDetalle.Response.FacturaDetalleCreateResponseDTO;
import com.aerolinea.aerolinea.service.Factura.FacturaDetalleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/facturaDetalle")
public class FacturaDetalleController {

    private final FacturaDetalleService facturaDetalleService;

    public FacturaDetalleController(FacturaDetalleService facturaDetalleService){
        this.facturaDetalleService = facturaDetalleService;
    }

    @PostMapping("/create")
    public ResponseEntity<FacturaDetalleCreateResponseDTO>create(@Valid @RequestBody FacturaDetalleCreateRequestDTO facturaDetalleCreateRequestDTO) {
        FacturaDetalleCreateResponseDTO facturaDetalle = facturaDetalleService.create(facturaDetalleCreateRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(facturaDetalle);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<FacturaDetalleGetAllResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(facturaDetalleService.getAll());
    }

    @PutMapping("/updateById/{fadId}")
    public ResponseEntity<Void> updateById(@PathVariable Long fadId, @Valid @RequestBody FacturaDetalleUpdateByIdRequestDTO facturaDetalleUpdateByIdRequestDTO) {
        facturaDetalleService.updateById(fadId, facturaDetalleUpdateByIdRequestDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteById/{fadId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long fadId) {
        facturaDetalleService.deleteById(fadId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
