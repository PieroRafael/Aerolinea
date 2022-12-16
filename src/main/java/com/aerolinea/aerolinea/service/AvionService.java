package com.aerolinea.aerolinea.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.aerolinea.aerolinea.dto.AvionListDTO;
import com.aerolinea.aerolinea.dto.AvionSaveDTO;
import com.aerolinea.aerolinea.exception.Exception;
import com.aerolinea.aerolinea.mapper.AvionMapper;
import com.aerolinea.aerolinea.persistence.entity.Avion;
import com.aerolinea.aerolinea.persistence.entity.Marca;
import com.aerolinea.aerolinea.persistence.entity.Modelo;
import com.aerolinea.aerolinea.persistence.repository.AvionRepository;

@Service
public class AvionService {

    private final AvionRepository avionRepository;

    private final AvionMapper avionMapper;

    public AvionService(AvionRepository avionRepository, AvionMapper avionMapper) {
        this.avionRepository = avionRepository;
        this.avionMapper = avionMapper;
    }

    public AvionSaveDTO create(AvionSaveDTO avionSaveDTO) {
        Avion avion = avionMapper.toDomain(avionSaveDTO);
        return avionMapper.toDto(avionRepository.save(avion));
    }

    public List<AvionListDTO> getAll() {
        return avionMapper.toLstDtoAvion(avionRepository.findAll());
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
        return avionMapper.toLstDtoAvion(avionRepository.getAllDeactivate());
    }

    public List<AvionListDTO> getAllActivated() {
        return avionMapper.toLstDtoAvion(avionRepository.getAllActivated());
    }

}
