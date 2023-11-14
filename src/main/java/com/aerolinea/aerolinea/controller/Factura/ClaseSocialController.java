package com.aerolinea.aerolinea.controller.Factura;

import com.aerolinea.aerolinea.dto.ClaseSocial.ClaseSocialDTO;
import com.aerolinea.aerolinea.service.Factura.ClaseSocialService;
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
    public ClaseSocialDTO Create(@Valid @RequestBody ClaseSocialDTO claseSocialDTO) {
        return claseSocialService.create(claseSocialDTO);
    }

    @GetMapping("/GetAll")
    public List<ClaseSocialDTO> GetAll() {
        return claseSocialService.getAll();
    }

    @PutMapping("/UpdateById/{clsId}")
    public void UpdateById(@RequestParam Long clsId, @Valid @RequestBody ClaseSocialDTO claseSocialDTO) {
        claseSocialService.updateById(clsId, claseSocialDTO);
    }

    @DeleteMapping("/DeleteById/{clsId}")
    public void DeleteById(@RequestParam Long clsId) {
        claseSocialService.deleteById(clsId);
    }

}
