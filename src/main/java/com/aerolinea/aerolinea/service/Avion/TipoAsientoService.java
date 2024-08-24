package com.aerolinea.aerolinea.service.Avion;

import com.aerolinea.aerolinea.dto.TipoAsiento.TipoAsientoDTO;
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

    public TipoAsientoDTO create(TipoAsientoDTO tipoAsientoDTO) {
        TipoAsiento tipoAsiento = modelMapper.map(tipoAsientoDTO , TipoAsiento.class);
        tipoAsiento.setTpaFCreate(LocalDateTime.now());
        tipoAsiento.setTpaUCreate("Piero");
        return modelMapper.map(tipoAsientoRepository.save(tipoAsiento) , TipoAsientoDTO.class);
    }

    public List<TipoAsientoDTO> getAll() {
        List<TipoAsiento> lstTipoAsiento = tipoAsientoRepository.findAll();
        List<TipoAsientoDTO> lstTipoAsientoDTO = lstTipoAsiento.stream()
                .map(tipoAsiento -> modelMapper.map(tipoAsiento,TipoAsientoDTO.class))
                .collect(Collectors.toList());
        return lstTipoAsientoDTO;
    }

    public void updateById(Long tpaId, TipoAsientoDTO tipoAsientoDTO) {
        Optional<TipoAsiento> findTipoAsientoById = tipoAsientoRepository.findById(tpaId);
        if (!findTipoAsientoById.isPresent()) {
            throw new ResourceNotFoundException("TipoAsiento Not Found");
        }
        TipoAsiento updateTipoAsiento = findTipoAsientoById.get();
        updateTipoAsiento.setTpaNombre(tipoAsientoDTO.getTpaNombre());
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
