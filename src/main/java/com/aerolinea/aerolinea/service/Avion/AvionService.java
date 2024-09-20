package com.aerolinea.aerolinea.service.Avion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.aerolinea.aerolinea.dto.Avion.Request.AvionUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.Avion.Response.AvionCreateResponseDTO;
import com.aerolinea.aerolinea.exception.custom.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.aerolinea.aerolinea.dto.Avion.Response.AvionGetAllResponseDTO;
import com.aerolinea.aerolinea.dto.Avion.Request.AvionCreateRequestDTO;
import com.aerolinea.aerolinea.persistence.entity.Avion.Avion;
import com.aerolinea.aerolinea.persistence.entity.Avion.Marca;
import com.aerolinea.aerolinea.persistence.entity.Avion.Modelo;
import com.aerolinea.aerolinea.persistence.repository.Avion.AvionRepository;

@Service
public class AvionService {

    private final AvionRepository avionRepository;
    private final ModelMapper modelMapper;

    public AvionService(AvionRepository avionRepository, ModelMapper modelMapper) {
        this.avionRepository = avionRepository;
        this.modelMapper = modelMapper;
    }

    public AvionCreateResponseDTO create(AvionCreateRequestDTO avionCreateRequestDTO) {
        Avion avion = modelMapper.map(avionCreateRequestDTO,Avion.class);
        avion.setAviFCreate(LocalDateTime.now());
        avion.setAviUCreate("Piero");
        return modelMapper.map(avionRepository.save(avion), AvionCreateResponseDTO.class);
    }

    public List<AvionGetAllResponseDTO> getAll() {
        List<Avion> lstAvion = avionRepository.findAll();
        List<AvionGetAllResponseDTO> lstAvionDTO = lstAvion.stream()
                .map(avion -> modelMapper.map(avion, AvionGetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstAvionDTO;
    }

    public void updateById(Long aviId, AvionUpdateByIdRequestDTO avionUpdateByIdRequestDTO) {
        Optional<Avion> findAvionById = avionRepository.findById(aviId);
        if (!findAvionById.isPresent()) {
            throw new ResourceNotFoundException("Avion Not Found");
        }
        Avion updateAvion = findAvionById.get();
        updateAvion.setAviCantidadAsientos(avionUpdateByIdRequestDTO.getAviCantidadAsientos());
        updateAvion.setAviRegistro(avionUpdateByIdRequestDTO.getAviRegistro());
        updateAvion.setMarca(Marca.builder().marId(avionUpdateByIdRequestDTO.getMarId()).build());
        updateAvion.setModelo(Modelo.builder().modId(avionUpdateByIdRequestDTO.getModId()).build());
        updateAvion.setAviFUpdate(LocalDateTime.now());
        updateAvion.setAviUUpdate("Piero");
        avionRepository.save(updateAvion);
    }

    public void deleteById(Long aviId) {
        Optional<Avion> findAvionById = avionRepository.findById(aviId);
        if (!findAvionById.isPresent()) {
            throw new ResourceNotFoundException("Avion Not Found");
        }
        avionRepository.deleteById(aviId);
    }

    public void deactivateByAviId(Long aviId) {
        Optional<Avion> findAvionById = avionRepository.findById(aviId);
        if (!findAvionById.isPresent()) {
            throw new ResourceNotFoundException("Avion Not Found");
        }
        avionRepository.deactivateByAviId(aviId);
    }

    public void activateByAviId(Long aviId) {
        Optional<Avion> findAvionById = avionRepository.findById(aviId);
        if (!findAvionById.isPresent()) {
            throw new ResourceNotFoundException("Avion Not Found");
        }
        avionRepository.activateByAviId(aviId);
    }

    public List<AvionGetAllResponseDTO> getAllDeactivate() {
        List<Avion> lstAvion = avionRepository.getAllDeactivate();
        List<AvionGetAllResponseDTO> lstAvionDTO = lstAvion.stream()
                .map(avion -> modelMapper.map(avion, AvionGetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstAvionDTO;
    }

    public List<AvionGetAllResponseDTO> getAllActivated() {
        List<Avion> lstAvion = avionRepository.getAllActivated();
        List<AvionGetAllResponseDTO> lstAvionDTO = lstAvion.stream()
                .map(avion -> modelMapper.map(avion, AvionGetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstAvionDTO;
    }

}
