package com.aerolinea.aerolinea.service.Avion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.aerolinea.aerolinea.exception.custom.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.aerolinea.aerolinea.dto.Avion.AvionListDTO;
import com.aerolinea.aerolinea.dto.Avion.AvionSaveDTO;
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

    public AvionSaveDTO create(AvionSaveDTO avionSaveDTO) {
        Avion avion = modelMapper.map(avionSaveDTO,Avion.class);
        avion.setAviFCreate(LocalDateTime.now());
        avion.setAviUCreate("Piero");
        return modelMapper.map(avionRepository.save(avion),AvionSaveDTO.class);
    }

    public List<AvionListDTO> getAll() {
        List<Avion> lstAvion = avionRepository.findAll();
        List<AvionListDTO> lstAvionDTO = lstAvion.stream()
                .map(avion -> modelMapper.map(avion,AvionListDTO.class))
                .collect(Collectors.toList());
        return lstAvionDTO;
    }

    public void updateById(Long aviId, AvionSaveDTO avionSaveDTO) {
        Optional<Avion> findAvionById = avionRepository.findById(aviId);
        if (!findAvionById.isPresent()) {
            throw new ResourceNotFoundException("Avion Not Found");
        }
        Avion updateAvion = findAvionById.get();
        updateAvion.setAviCantidadAsientos(avionSaveDTO.getAviCantidadAsientos());
        updateAvion.setAviRegistro(avionSaveDTO.getAviRegistro());
        updateAvion.setMarca(Marca.builder().marId(avionSaveDTO.getMarId()).build());
        updateAvion.setModelo(Modelo.builder().modId(avionSaveDTO.getModId()).build());
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

    public List<AvionListDTO> getAllDeactivate() {
        List<Avion> lstAvion = avionRepository.getAllDeactivate();
        List<AvionListDTO> lstAvionDTO = lstAvion.stream()
                .map(avion -> modelMapper.map(avion,AvionListDTO.class))
                .collect(Collectors.toList());
        return lstAvionDTO;
    }

    public List<AvionListDTO> getAllActivated() {
        List<Avion> lstAvion = avionRepository.getAllActivated();
        List<AvionListDTO> lstAvionDTO = lstAvion.stream()
                .map(avion -> modelMapper.map(avion,AvionListDTO.class))
                .collect(Collectors.toList());
        return lstAvionDTO;
    }

}
