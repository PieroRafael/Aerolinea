package com.aerolinea.aerolinea.controller.Usuario;

import com.aerolinea.aerolinea.dto.Usuario.UsuarioListDTO;
import com.aerolinea.aerolinea.dto.Usuario.UsuarioSaveDTO;
import com.aerolinea.aerolinea.service.Usuario.UsuarioService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/Create")
    public UsuarioSaveDTO Create(@Valid @RequestBody UsuarioSaveDTO usuarioSaveDTO){
        return usuarioService.create(usuarioSaveDTO);
    }

    @GetMapping("/GetAll")
    public List<UsuarioListDTO> GetAll() {
        return usuarioService.getAll();
    }

    @PutMapping("/UpdateById/{usuId}")
    public void UpdateById(@RequestParam Long usuId, @Valid @RequestBody UsuarioSaveDTO usuarioSaveDTO) {
        usuarioService.updateById(usuId, usuarioSaveDTO);
    }

    @DeleteMapping("/DeleteById/{usuId}")
    public void DeleteById(@RequestParam Long usuId) {
        usuarioService.deleteById(usuId);
    }

    @PatchMapping("/DeactivateByAviId/{usuId}")
    public void DeactivateByAviId(@RequestParam Long usuId) {
        usuarioService.deactivateByUsuId(usuId);
    }

    @PatchMapping("/ActivateByAviId/{usuId}")
    public void ActivateByAviId(@RequestParam Long usuId) {
        usuarioService.activateByUsuId(usuId);
    }

    @GetMapping("/GetAllDeactivate")
    public List<UsuarioListDTO> GetAllDeactivate() {
        return usuarioService.getAllDeactivate();
    }

    @GetMapping("/GetAllActivated")
    public List<UsuarioListDTO> GetAllActivated() {
        return usuarioService.getAllActivated();
    }

}
