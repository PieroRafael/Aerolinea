package com.aerolinea.aerolinea.controller.Factura;

import com.aerolinea.aerolinea.dto.ClaseSocial.Request.ClaseSocialCreateRequestDTO;
import com.aerolinea.aerolinea.dto.ClaseSocial.Request.ClaseSocialUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.ClaseSocial.Response.ClaseSocialCreateResponseDTO;
import com.aerolinea.aerolinea.dto.ClaseSocial.Response.ClaseSocialGetAllResponseDTO;
import com.aerolinea.aerolinea.service.Factura.ClaseSocialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/claseSocial")
public class ClaseSocialController {

    private final ClaseSocialService claseSocialService;

    public ClaseSocialController(ClaseSocialService claseSocialService){
        this.claseSocialService = claseSocialService;
    }

    @PostMapping("/create")
    public ResponseEntity<ClaseSocialCreateResponseDTO> create(@Valid @RequestBody ClaseSocialCreateRequestDTO claseSocialCreateRequestDTO) {
        ClaseSocialCreateResponseDTO claseSocial = claseSocialService.create(claseSocialCreateRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(claseSocial);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ClaseSocialGetAllResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(claseSocialService.getAll());
    }

    @PutMapping("/updateById/{clsId}")
    public ResponseEntity<Void> updateById(@PathVariable Long clsId, @Valid @RequestBody ClaseSocialUpdateByIdRequestDTO claseSocialUpdateByIdRequestDTO) {
        claseSocialService.updateById(clsId, claseSocialUpdateByIdRequestDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteById/{clsId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long clsId) {
        claseSocialService.deleteById(clsId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
