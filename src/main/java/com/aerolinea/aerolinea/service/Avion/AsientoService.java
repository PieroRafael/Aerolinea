package com.aerolinea.aerolinea.service.Avion;

import com.aerolinea.aerolinea.dto.Asiento.AsientoListDTO;
import com.aerolinea.aerolinea.dto.Asiento.AsientoSaveDTO;
import com.aerolinea.aerolinea.exception.custom.ResourceNotFoundException;
import com.aerolinea.aerolinea.persistence.entity.Avion.*;
import com.aerolinea.aerolinea.persistence.repository.Avion.AsientoRepository;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AsientoService {

    private final AsientoRepository asientoRepository;

    private final ModelMapper modelMapper;

    public AsientoService(AsientoRepository asientoRepository,ModelMapper modelMapper){
        this.asientoRepository = asientoRepository;
        this.modelMapper = modelMapper;
    }

    public AsientoSaveDTO create(AsientoSaveDTO asientoSaveDTO) {
        Asiento asiento = modelMapper.map(asientoSaveDTO,Asiento.class);
        asiento.setAstFCreate(LocalDateTime.now());
        asiento.setAstUCreate("Piero");
        return modelMapper.map(asientoRepository.save(asiento),AsientoSaveDTO.class);
    }

    public List<AsientoListDTO> getAll() {
        List<Asiento> lstAsiento = asientoRepository.findAll();
        List<AsientoListDTO> lstAsientoListDTO = lstAsiento.stream()
                .map(asiento -> modelMapper.map(asiento,AsientoListDTO.class))
                .collect(Collectors.toList());
        return lstAsientoListDTO;
    }

    public void updateById(Long astId, AsientoSaveDTO asientoSaveDTO) {
        Optional<Asiento> findAsientoById = asientoRepository.findById(astId);
        if (!findAsientoById.isPresent()) {
            throw new ResourceNotFoundException("Asiento Not Found");
        }
        Asiento updateAsiento = findAsientoById.get();
        updateAsiento.setTipoAsiento(TipoAsiento.builder().tpaId(asientoSaveDTO.getTpaId()).build());
        updateAsiento.setAvion(Avion.builder().aviId(asientoSaveDTO.getAviId()).build());
        updateAsiento.setAstNombre(asientoSaveDTO.getAstNombre());
        updateAsiento.setAstFUpdate(LocalDateTime.now());
        updateAsiento.setAstUUpdate("Piero");
        asientoRepository.save(updateAsiento);
    }

    public void deleteById(Long astId) {
        Optional<Asiento> findAsientoById = asientoRepository.findById(astId);
        if (!findAsientoById.isPresent()) {
            throw new ResourceNotFoundException("Asiento Not Found");
        }
        asientoRepository.deleteById(astId);
    }

    public void deactivateByAstId(Long astId) {
        Optional<Asiento> findAsientoById = asientoRepository.findById(astId);
        if (!findAsientoById.isPresent()) {
            throw new ResourceNotFoundException("Asiento Not Found");
        }
        asientoRepository.deactivateByAstId(astId);
    }

    public void activateByAstId(Long astId) {
        Optional<Asiento> findAsientoById = asientoRepository.findById(astId);
        if (!findAsientoById.isPresent()) {
            throw new ResourceNotFoundException("Asiento Not Found");
        }
        asientoRepository.activateByAstId(astId);
    }

    public List<AsientoListDTO> getAllDeactivate() {
        List<Asiento> lstAsiento = asientoRepository.getAllDeactivate();
        List<AsientoListDTO> lstAsientoDTO = lstAsiento.stream()
                .map(asiento -> modelMapper.map(asiento,AsientoListDTO.class))
                .collect(Collectors.toList());
        return lstAsientoDTO;
    }

    public List<AsientoListDTO> getAllActivated() {
        List<Asiento> lstAsiento = asientoRepository.getAllActivated();
        List<AsientoListDTO> lstAsientoDTO = lstAsiento.stream()
                .map(asiento -> modelMapper.map(asiento,AsientoListDTO.class))
                .collect(Collectors.toList());
        return lstAsientoDTO;
    }

}
