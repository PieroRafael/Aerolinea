package com.aerolinea.aerolinea.controller.Ruta;

import com.aerolinea.aerolinea.dto.PuntoEscala.Request.PuntoEscalaCreateRequestDTO;
import com.aerolinea.aerolinea.dto.PuntoEscala.Request.PuntoEscalaUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.PuntoEscala.Response.PuntoEscalaCreateResponseDTO;
import com.aerolinea.aerolinea.dto.PuntoEscala.Response.PuntoEscalaGetAllResponseDTO;
import com.aerolinea.aerolinea.service.Ruta.PuntoEscalaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/puntoEscala")
public class PuntoEscalaController {

    private final PuntoEscalaService puntoEscalaService;

    public PuntoEscalaController(PuntoEscalaService puntoEscalaService){
        this.puntoEscalaService = puntoEscalaService;
    }

    @PostMapping("/create")
    public ResponseEntity<PuntoEscalaCreateResponseDTO> create(@Valid @RequestBody PuntoEscalaCreateRequestDTO puntoEscalaCreateRequestDTO){
        PuntoEscalaCreateResponseDTO puntoEscala = puntoEscalaService.create(puntoEscalaCreateRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(puntoEscala);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PuntoEscalaGetAllResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(puntoEscalaService.getAll());
    }

    @PutMapping("/updateById/{pesId}")
    public ResponseEntity<Void> updateById(@PathVariable Long pesId, @Valid @RequestBody PuntoEscalaUpdateByIdRequestDTO puntoEscalaUpdateByIdRequestDTO) {
        puntoEscalaService.updateById(pesId, puntoEscalaUpdateByIdRequestDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteById/{pesId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long pesId) {
        puntoEscalaService.deleteById(pesId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
