package com.aerolinea.aerolinea.service.Avion;

import com.aerolinea.aerolinea.dto.TipoAsiento.Request.TipoAsientoCreateRequestDTO;
import com.aerolinea.aerolinea.dto.TipoAsiento.Request.TipoAsientoUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.TipoAsiento.Response.TipoAsientoCreateResponseDTO;
import com.aerolinea.aerolinea.dto.TipoAsiento.Response.TipoAsientoGetAllResponseDTO;
import com.aerolinea.aerolinea.exception.custom.ResourceNotFoundException;
import com.aerolinea.aerolinea.persistence.entity.Avion.TipoAsiento;
import com.aerolinea.aerolinea.persistence.repository.Avion.TipoAsientoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoAsientoService {

    private final TipoAsientoRepository tipoAsientoRepository;
    private final ModelMapper modelMapper;

    public TipoAsientoService(TipoAsientoRepository tipoAsientoRepository,ModelMapper modelMapper) {
        this.tipoAsientoRepository = tipoAsientoRepository;
        this.modelMapper = modelMapper;
    }

    public TipoAsientoCreateResponseDTO create(TipoAsientoCreateRequestDTO tipoAsientoCreateRequestDTO) {
        TipoAsiento tipoAsiento = modelMapper.map(tipoAsientoCreateRequestDTO, TipoAsiento.class);
        tipoAsiento.setTpaFCreate(LocalDateTime.now());
        tipoAsiento.setTpaUCreate("Piero");
        return modelMapper.map(tipoAsientoRepository.save(tipoAsiento) , TipoAsientoCreateResponseDTO.class);
    }

    public List<TipoAsientoGetAllResponseDTO> getAll() {
        List<TipoAsiento> lstTipoAsiento = tipoAsientoRepository.findAll();
        List<TipoAsientoGetAllResponseDTO> lstTipoAsientoGetAllResponseDTO = lstTipoAsiento.stream()
                .map(tipoAsiento -> modelMapper.map(tipoAsiento, TipoAsientoGetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstTipoAsientoGetAllResponseDTO;
    }

    public void updateById(Long tpaId, TipoAsientoUpdateByIdRequestDTO tipoAsientoUpdateByIdRequestDTO) {
        Optional<TipoAsiento> findTipoAsientoById = tipoAsientoRepository.findById(tpaId);
        if (!findTipoAsientoById.isPresent()) {
            throw new ResourceNotFoundException("TipoAsiento Not Found");
        }
        TipoAsiento updateTipoAsiento = findTipoAsientoById.get();
        updateTipoAsiento.setTpaNombre(tipoAsientoUpdateByIdRequestDTO.getTpaNombre());
        updateTipoAsiento.setTpaFUpdate(LocalDateTime.now());
        updateTipoAsiento.setTpaUUpdate("Piero");
        tipoAsientoRepository.save(updateTipoAsiento);
    }

    public void deleteById(Long tpaId) {
        Optional<TipoAsiento> findTipoAsientoById = tipoAsientoRepository.findById(tpaId);
        if (!findTipoAsientoById.isPresent()) {
            throw new ResourceNotFoundException("TipoAsiento Not Found");
        }
        tipoAsientoRepository.deleteById(tpaId);
    }

}
