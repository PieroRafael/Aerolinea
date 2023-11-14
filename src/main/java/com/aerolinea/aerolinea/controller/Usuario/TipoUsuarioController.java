package com.aerolinea.aerolinea.controller.Usuario;

import com.aerolinea.aerolinea.dto.TipoUsuario.TipoUsuarioDTO;
import com.aerolinea.aerolinea.service.Usuario.TipoUsuarioService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/TipoUsuario")
public class TipoUsuarioController {

    private final TipoUsuarioService tipoUsuarioService;

    public TipoUsuarioController(TipoUsuarioService tipoUsuarioService){
        this.tipoUsuarioService = tipoUsuarioService;
    }

    @PostMapping("/Create")
    public TipoUsuarioDTO Create(@Valid @RequestBody TipoUsuarioDTO tipoUsuarioDTO) {
        return tipoUsuarioService.create(tipoUsuarioDTO);
    }

    @GetMapping("/GetAll")
    public List<TipoUsuarioDTO> GetAll() {
        return tipoUsuarioService.getAll();
    }


    @PutMapping("/UpdateById/{tpuId}")
    public void UpdateById(@RequestParam Long tpuId, @Valid @RequestBody TipoUsuarioDTO tipoUsuarioDTO) {
        tipoUsuarioService.updateById(tpuId, tipoUsuarioDTO);
    }

    @DeleteMapping("/DeleteById/{tpuId}")
    public void DeleteById(@RequestParam Long tpuId) {
        tipoUsuarioService.deleteById(tpuId);
    }

}
