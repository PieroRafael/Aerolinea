package com.aerolinea.aerolinea.service.Usuario;

import com.aerolinea.aerolinea.dto.TipoUsuario.TipoUsuarioDTO;
import com.aerolinea.aerolinea.exception.Exception;
import com.aerolinea.aerolinea.persistence.entity.Usuario.TipoUsuario;
import com.aerolinea.aerolinea.persistence.repository.Usuario.TipoUsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoUsuarioService {

    private final TipoUsuarioRepository tipoUsuarioRepository;
    private final ModelMapper modelMapper;

    public TipoUsuarioService(TipoUsuarioRepository tipoUsuarioRepository , ModelMapper modelMapper) {
        this.tipoUsuarioRepository = tipoUsuarioRepository;
        this.modelMapper = modelMapper;
    }

    public TipoUsuarioDTO create(TipoUsuarioDTO tipoUsuarioDTO){
        TipoUsuario tipoUsuario = modelMapper.map(tipoUsuarioDTO,TipoUsuario.class);
        tipoUsuario.setTpuFCreate(LocalDateTime.now());
        return modelMapper.map(tipoUsuarioRepository.save(tipoUsuario) , TipoUsuarioDTO.class);
    }

    public List<TipoUsuarioDTO> getAll(){
        List<TipoUsuario> lstTipoUsuario = tipoUsuarioRepository.findAll();
        List<TipoUsuarioDTO> lstTipoUsuarioDTO = lstTipoUsuario.stream()
                .map(tipoUsuario -> modelMapper.map(tipoUsuario,TipoUsuarioDTO.class))
                .collect(Collectors.toList());
        return lstTipoUsuarioDTO;
    }

    public TipoUsuarioDTO updateById(Long tpuId , TipoUsuarioDTO tipoUsuarioDTO){
        Optional<TipoUsuario> findTipousuarioById = tipoUsuarioRepository.findById(tpuId);
        if (!findTipousuarioById.isPresent()) {
            throw new Exception("TipoUsuario Not Found", HttpStatus.NOT_FOUND);
        }
        TipoUsuario updateTipoUsuario = findTipousuarioById.get();
        updateTipoUsuario.setTpuNombre(tipoUsuarioDTO.getTpuNombre());
        updateTipoUsuario.setTpuFUpdate(LocalDateTime.now());
        tipoUsuarioRepository.save(updateTipoUsuario);
        throw new Exception("TipoUsuario Update Successful", HttpStatus.OK);
    }

    public void deleteById(Long tpuId){
        Optional<TipoUsuario> findTipoUsuarioById = tipoUsuarioRepository.findById(tpuId);
        if(!findTipoUsuarioById.isPresent()){
            throw new Exception("TipoUsuario Not Found", HttpStatus.NOT_FOUND);
        }
        tipoUsuarioRepository.deleteById(tpuId);
        throw new Exception("TipoUsuario Removed Successful" , HttpStatus.OK);
    }

}
