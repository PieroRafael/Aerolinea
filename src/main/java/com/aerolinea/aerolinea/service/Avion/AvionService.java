package com.aerolinea.aerolinea.service.Avion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.aerolinea.aerolinea.dto.Avion.Request.UpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.Avion.Response.CreateResponseDTO;
import com.aerolinea.aerolinea.exception.custom.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.aerolinea.aerolinea.dto.Avion.Response.GetAllResponseDTO;
import com.aerolinea.aerolinea.dto.Avion.Request.CreateRequestDTO;
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

    public CreateResponseDTO create(CreateRequestDTO createRequestDTO) {
        Avion avion = modelMapper.map(createRequestDTO,Avion.class);
        avion.setAviFCreate(LocalDateTime.now());
        avion.setAviUCreate("Piero");
        return modelMapper.map(avionRepository.save(avion), CreateResponseDTO.class);
    }

    public List<GetAllResponseDTO> getAll() {
        List<Avion> lstAvion = avionRepository.findAll();
        List<GetAllResponseDTO> lstAvionDTO = lstAvion.stream()
                .map(avion -> modelMapper.map(avion, GetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstAvionDTO;
    }

    public void updateById(Long aviId, UpdateByIdRequestDTO updateByIdRequestDTO) {
        Optional<Avion> findAvionById = avionRepository.findById(aviId);
        if (!findAvionById.isPresent()) {
            throw new ResourceNotFoundException("Avion Not Found");
        }
        Avion updateAvion = findAvionById.get();
        updateAvion.setAviCantidadAsientos(updateByIdRequestDTO.getAviCantidadAsientos());
        updateAvion.setAviRegistro(updateByIdRequestDTO.getAviRegistro());
        updateAvion.setMarca(Marca.builder().marId(updateByIdRequestDTO.getMarId()).build());
        updateAvion.setModelo(Modelo.builder().modId(updateByIdRequestDTO.getModId()).build());
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

    public List<GetAllResponseDTO> getAllDeactivate() {
        List<Avion> lstAvion = avionRepository.getAllDeactivate();
        List<GetAllResponseDTO> lstAvionDTO = lstAvion.stream()
                .map(avion -> modelMapper.map(avion, GetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstAvionDTO;
    }

    public List<GetAllResponseDTO> getAllActivated() {
        List<Avion> lstAvion = avionRepository.getAllActivated();
        List<GetAllResponseDTO> lstAvionDTO = lstAvion.stream()
                .map(avion -> modelMapper.map(avion, GetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstAvionDTO;
    }

}
