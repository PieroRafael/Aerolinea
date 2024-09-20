package com.aerolinea.aerolinea.service.Avion;

import com.aerolinea.aerolinea.dto.Asiento.Request.AsientoUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.Asiento.Response.AsientoGetAllResponseDTO;
import com.aerolinea.aerolinea.dto.Asiento.Request.AsientoCreateRequestDTO;
import com.aerolinea.aerolinea.dto.Asiento.Response.AsientoCreateResponseDTO;
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

    public AsientoCreateResponseDTO create(AsientoCreateRequestDTO asientoCreateRequestDTO) {
        Asiento asiento = modelMapper.map(asientoCreateRequestDTO,Asiento.class);
        asiento.setAstFCreate(LocalDateTime.now());
        asiento.setAstUCreate("Piero");
        return modelMapper.map(asientoRepository.save(asiento), AsientoCreateResponseDTO.class);
    }

    public List<AsientoGetAllResponseDTO> getAll() {
        List<Asiento> lstAsiento = asientoRepository.findAll();
        List<AsientoGetAllResponseDTO> lstAsientoGetAllResponseDTO = lstAsiento.stream()
                .map(asiento -> modelMapper.map(asiento, AsientoGetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstAsientoGetAllResponseDTO;
    }

    public void updateById(Long astId, AsientoUpdateByIdRequestDTO asientoUpdateByIdRequestDTO) {
        Optional<Asiento> findAsientoById = asientoRepository.findById(astId);
        if (!findAsientoById.isPresent()) {
            throw new ResourceNotFoundException("Asiento Not Found");
        }
        Asiento updateAsiento = findAsientoById.get();
        updateAsiento.setTipoAsiento(TipoAsiento.builder().tpaId(asientoUpdateByIdRequestDTO.getTpaId()).build());
        updateAsiento.setAvion(Avion.builder().aviId(asientoUpdateByIdRequestDTO.getAviId()).build());
        updateAsiento.setAstNombre(asientoUpdateByIdRequestDTO.getAstNombre());
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

    public List<AsientoGetAllResponseDTO> getAllDeactivate() {
        List<Asiento> lstAsiento = asientoRepository.getAllDeactivate();
        List<AsientoGetAllResponseDTO> lstAsientoDTO = lstAsiento.stream()
                .map(asiento -> modelMapper.map(asiento, AsientoGetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstAsientoDTO;
    }

    public List<AsientoGetAllResponseDTO> getAllActivated() {
        List<Asiento> lstAsiento = asientoRepository.getAllActivated();
        List<AsientoGetAllResponseDTO> lstAsientoDTO = lstAsiento.stream()
                .map(asiento -> modelMapper.map(asiento, AsientoGetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstAsientoDTO;
    }

}
