package com.aerolinea.aerolinea.controller.Ruta;

import com.aerolinea.aerolinea.dto.PuntoRuta.Request.PuntoRutaUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.PuntoRuta.Response.PuntoRutaCreateResponseDTO;
import com.aerolinea.aerolinea.dto.PuntoRuta.Response.PuntoRutaGetAllResponseDTO;
import com.aerolinea.aerolinea.dto.PuntoRuta.Request.PuntoRutaCreateRequestDTO;
import com.aerolinea.aerolinea.service.Ruta.PuntoRutaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/puntoRuta")
public class PuntoRutaController {

    private final PuntoRutaService puntoRutaService;

    public PuntoRutaController(PuntoRutaService puntoRutaService){
        this.puntoRutaService = puntoRutaService;
    }

    @PostMapping("/create")
    public ResponseEntity<PuntoRutaCreateResponseDTO> create(@Valid @RequestBody PuntoRutaCreateRequestDTO puntoRutaCreateRequestDTO){
        PuntoRutaCreateResponseDTO puntoRuta = puntoRutaService.create(puntoRutaCreateRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(puntoRuta);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PuntoRutaGetAllResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(puntoRutaService.getAll());
    }

    @PutMapping("/updateById/{ptrId}")
    public ResponseEntity<Void> updateById(@PathVariable Long ptrId, @Valid @RequestBody PuntoRutaUpdateByIdRequestDTO puntoRutaUpdateByIdRequestDTO) {
        puntoRutaService.updateById(ptrId, puntoRutaUpdateByIdRequestDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteById/{ptrId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long ptrId) {
        puntoRutaService.deleteById(ptrId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
