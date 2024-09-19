package com.aerolinea.aerolinea.controller.Factura;

import com.aerolinea.aerolinea.dto.ClaseSocial.Request.CreateRequestDTO;
import com.aerolinea.aerolinea.dto.ClaseSocial.Request.UpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.ClaseSocial.Response.CreateResponseDTO;
import com.aerolinea.aerolinea.dto.ClaseSocial.Response.GetAllResponseDTO;
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
    public ResponseEntity<CreateResponseDTO> create(@Valid @RequestBody CreateRequestDTO createRequestDTO) {
        CreateResponseDTO claseSocial = claseSocialService.create(createRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(claseSocial);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<GetAllResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(claseSocialService.getAll());
    }

    @PutMapping("/updateById/{clsId}")
    public ResponseEntity<Void> updateById(@PathVariable Long clsId, @Valid @RequestBody UpdateByIdRequestDTO updateByIdRequestDTO) {
        claseSocialService.updateById(clsId, updateByIdRequestDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteById/{clsId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long clsId) {
        claseSocialService.deleteById(clsId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
