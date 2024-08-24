package com.aerolinea.aerolinea.controller.Ruta;

import com.aerolinea.aerolinea.dto.PuntoRuta.PuntoRutaListDTO;
import com.aerolinea.aerolinea.dto.PuntoRuta.PuntoRutaSaveDTO;
import com.aerolinea.aerolinea.service.Ruta.PuntoRutaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<PuntoRutaSaveDTO> Create(@Valid @RequestBody PuntoRutaSaveDTO puntoRutaSaveDTO){
        PuntoRutaSaveDTO puntoRuta = puntoRutaService.create(puntoRutaSaveDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Message", "PuntoRuta creado correctamente")
                .body(puntoRuta);
    }

    @GetMapping("/GetAll")
    public ResponseEntity<List<PuntoRutaListDTO>> GetAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(puntoRutaService.getAll());
    }

    @PutMapping("/UpdateById/{ptrId}")
    public ResponseEntity<Void> UpdateById(@PathVariable Long ptrId, @Valid @RequestBody PuntoRutaSaveDTO puntoRutaSaveDTO) {
        puntoRutaService.updateById(ptrId, puntoRutaSaveDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/DeleteById/{ptrId}")
    public ResponseEntity<Void> DeleteById(@PathVariable Long ptrId) {
        puntoRutaService.deleteById(ptrId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
