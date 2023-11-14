package com.aerolinea.aerolinea.service.Usuario;

import com.aerolinea.aerolinea.dto.Usuario.UsuarioListDTO;
import com.aerolinea.aerolinea.dto.Usuario.UsuarioSaveDTO;
import com.aerolinea.aerolinea.exception.Exception;
import com.aerolinea.aerolinea.persistence.entity.Usuario.TipoUsuario;
import com.aerolinea.aerolinea.persistence.entity.Usuario.Usuario;
import com.aerolinea.aerolinea.persistence.repository.Usuario.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    public UsuarioService(UsuarioRepository usuarioRepository , ModelMapper modelMapper){
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }

    public UsuarioSaveDTO create(UsuarioSaveDTO usuarioSaveDTO) {
        Usuario usuario = modelMapper.map(usuarioSaveDTO , Usuario.class);
        usuario.setUsuFCreate(LocalDateTime.now());
        return modelMapper.map(usuarioRepository.save(usuario) , UsuarioSaveDTO.class);
    }

    public List<UsuarioListDTO> getAll() {
        List<Usuario> lstUsuario = usuarioRepository.findAll();
        List<UsuarioListDTO> lstUsuarioDTO = lstUsuario.stream()
                .map(usuario -> modelMapper.map(usuario,UsuarioListDTO.class))
                .collect(Collectors.toList());
        return lstUsuarioDTO;
    }

    public void updateById(Long usuId, UsuarioSaveDTO usuarioSaveDTO) {
        Optional<Usuario> findUsuarioById = usuarioRepository.findById(usuId);
        if (!findUsuarioById.isPresent()) {
            throw new Exception("Usuario Not Found", HttpStatus.NOT_FOUND);
        }
        Usuario updateUsuario = findUsuarioById.get();
        updateUsuario.setUsuEmail(usuarioSaveDTO.getUsuEmail());
        updateUsuario.setUsuContraseña(usuarioSaveDTO.getUsuContraseña());
        updateUsuario.setTipoUsuario(TipoUsuario.builder().tpuId(usuarioSaveDTO.getTpuId()).build());
        updateUsuario.setUsuFUpdate(LocalDateTime.now());
        usuarioRepository.save(updateUsuario);
        throw new Exception("Usuario Update Successful", HttpStatus.OK);
    }

    public void deleteById(Long usuId) {
        Optional<Usuario> findUsuarioById = usuarioRepository.findById(usuId);
        if (!findUsuarioById.isPresent()) {
            throw new Exception("Usuario Not Found", HttpStatus.NOT_FOUND);
        }
        usuarioRepository.deleteById(usuId);
        throw new Exception("Usuario Removed Successful", HttpStatus.OK);
    }

    public void deactivateByUsuId(Long usuId) {
        Optional<Usuario> findUsuarioById = usuarioRepository.findById(usuId);
        if (!findUsuarioById.isPresent()) {
            throw new Exception("Usuario Not Found", HttpStatus.NOT_FOUND);
        }
        usuarioRepository.deactivateByUsuId(usuId);
        throw new Exception("Usuario Status : Disabled ", HttpStatus.OK);
    }

    public void activateByUsuId(Long usuId) {
        Optional<Usuario> findUsuarioById = usuarioRepository.findById(usuId);
        if (!findUsuarioById.isPresent()) {
            throw new Exception("Usuario Not Found", HttpStatus.NOT_FOUND);
        }
        usuarioRepository.activateByUsuId(usuId);
        throw new Exception("Usuario Status : Activated ", HttpStatus.OK);
    }

    public List<UsuarioListDTO> getAllDeactivate() {
        List<Usuario> lstUsuario = usuarioRepository.getAllDeactivate();
        List<UsuarioListDTO> lstUsuarioDTO = lstUsuario.stream()
                .map(usuario -> modelMapper.map(usuario,UsuarioListDTO.class))
                .collect(Collectors.toList());
        return lstUsuarioDTO;
    }

    public List<UsuarioListDTO> getAllActivated() {
        List<Usuario> lstUsuario = usuarioRepository.getAllActivated();
        List<UsuarioListDTO> lstUsuarioDTO = lstUsuario.stream()
                .map(usuario -> modelMapper.map(usuario,UsuarioListDTO.class))
                .collect(Collectors.toList());
        return lstUsuarioDTO;
    }

}
