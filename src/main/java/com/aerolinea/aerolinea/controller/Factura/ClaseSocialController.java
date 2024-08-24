package com.aerolinea.aerolinea.controller.Factura;

import com.aerolinea.aerolinea.dto.ClaseSocial.ClaseSocialDTO;
import com.aerolinea.aerolinea.service.Factura.ClaseSocialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ClaseSocial")
public class ClaseSocialController {

    private final ClaseSocialService claseSocialService;

    public ClaseSocialController(ClaseSocialService claseSocialService){
        this.claseSocialService = claseSocialService;
    }

    @PostMapping("/Create")
    public ResponseEntity<ClaseSocialDTO> Create(@Valid @RequestBody ClaseSocialDTO claseSocialDTO) {
        ClaseSocialDTO claseSocial = claseSocialService.create(claseSocialDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Message", "ClaseSocial creado correctamente")
                .body(claseSocial);
    }

    @GetMapping("/GetAll")
    public ResponseEntity<List<ClaseSocialDTO>> GetAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(claseSocialService.getAll());
    }

    @PutMapping("/UpdateById/{clsId}")
    public ResponseEntity<Void> UpdateById(@PathVariable Long clsId, @Valid @RequestBody ClaseSocialDTO claseSocialDTO) {
        claseSocialService.updateById(clsId, claseSocialDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/DeleteById/{clsId}")
    public ResponseEntity<Void> DeleteById(@PathVariable Long clsId) {
        claseSocialService.deleteById(clsId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
