package com.aerolinea.aerolinea.service.Avion;

import com.aerolinea.aerolinea.dto.Asiento.Request.UpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.Asiento.Response.GetAllResponseDTO;
import com.aerolinea.aerolinea.dto.Asiento.Request.CreateRequestDTO;
import com.aerolinea.aerolinea.dto.Asiento.Response.CreateResponseDTO;
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

    public CreateResponseDTO create(CreateRequestDTO createRequestDTO) {
        Asiento asiento = modelMapper.map(createRequestDTO,Asiento.class);
        asiento.setAstFCreate(LocalDateTime.now());
        asiento.setAstUCreate("Piero");
        return modelMapper.map(asientoRepository.save(asiento), CreateResponseDTO.class);
    }

    public List<GetAllResponseDTO> getAll() {
        List<Asiento> lstAsiento = asientoRepository.findAll();
        List<GetAllResponseDTO> lstGetAllResponseDTO = lstAsiento.stream()
                .map(asiento -> modelMapper.map(asiento, GetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstGetAllResponseDTO;
    }

    public void updateById(Long astId, UpdateByIdRequestDTO updateByIdRequestDTO) {
        Optional<Asiento> findAsientoById = asientoRepository.findById(astId);
        if (!findAsientoById.isPresent()) {
            throw new ResourceNotFoundException("Asiento Not Found");
        }
        Asiento updateAsiento = findAsientoById.get();
        updateAsiento.setTipoAsiento(TipoAsiento.builder().tpaId(updateByIdRequestDTO.getTpaId()).build());
        updateAsiento.setAvion(Avion.builder().aviId(updateByIdRequestDTO.getAviId()).build());
        updateAsiento.setAstNombre(updateByIdRequestDTO.getAstNombre());
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

    public List<GetAllResponseDTO> getAllDeactivate() {
        List<Asiento> lstAsiento = asientoRepository.getAllDeactivate();
        List<GetAllResponseDTO> lstAsientoDTO = lstAsiento.stream()
                .map(asiento -> modelMapper.map(asiento, GetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstAsientoDTO;
    }

    public List<GetAllResponseDTO> getAllActivated() {
        List<Asiento> lstAsiento = asientoRepository.getAllActivated();
        List<GetAllResponseDTO> lstAsientoDTO = lstAsiento.stream()
                .map(asiento -> modelMapper.map(asiento, GetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstAsientoDTO;
    }

}
