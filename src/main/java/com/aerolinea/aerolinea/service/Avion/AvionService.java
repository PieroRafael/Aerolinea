package com.aerolinea.aerolinea.service.Avion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.aerolinea.aerolinea.dto.Avion.AvionListDTO;
import com.aerolinea.aerolinea.dto.Avion.AvionSaveDTO;
import com.aerolinea.aerolinea.exception.Exception;
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
            throw new Exception("Avion Not Found", HttpStatus.NOT_FOUND);
        }
        Avion updateAvion = findAvionById.get();
        updateAvion.setAviCantidadAsientos(avionSaveDTO.getAviCantidadAsientos());
        updateAvion.setAviRegistro(avionSaveDTO.getAviRegistro());
        updateAvion.setMarca(Marca.builder().marId(avionSaveDTO.getMarId()).build());
        updateAvion.setModelo(Modelo.builder().modId(avionSaveDTO.getModId()).build());
        updateAvion.setAviFUpdate(LocalDateTime.now());
        updateAvion.setAviUUpdate("Piero");
        avionRepository.save(updateAvion);
        throw new Exception("Avion Update Successful", HttpStatus.OK);
    }

    public void deleteById(Long aviId) {
        Optional<Avion> findAvionById = avionRepository.findById(aviId);
        if (!findAvionById.isPresent()) {
            throw new Exception("Avion Not Found", HttpStatus.NOT_FOUND);
        }
        avionRepository.deleteById(aviId);
        throw new Exception("Avion Removed Successful", HttpStatus.OK);
    }

    public void deactivateByAviId(Long aviId) {
        Optional<Avion> findAvionById = avionRepository.findById(aviId);
        if (!findAvionById.isPresent()) {
            throw new Exception("Avion Not Found", HttpStatus.NOT_FOUND);
        }
        avionRepository.deactivateByAviId(aviId);
        throw new Exception("Avion Status : Disabled ", HttpStatus.OK);
    }

    public void activateByAviId(Long aviId) {
        Optional<Avion> findAvionById = avionRepository.findById(aviId);
        if (!findAvionById.isPresent()) {
            throw new Exception("Avion Not Found", HttpStatus.NOT_FOUND);
        }
        avionRepository.activateByAviId(aviId);
        throw new Exception("Avion Status : Activated ", HttpStatus.OK);
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
