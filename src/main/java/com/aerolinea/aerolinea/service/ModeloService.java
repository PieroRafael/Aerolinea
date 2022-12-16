package com.aerolinea.aerolinea.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.aerolinea.aerolinea.dto.ModeloDTO;
import com.aerolinea.aerolinea.exception.Exception;
import com.aerolinea.aerolinea.mapper.ModeloMapper;
import com.aerolinea.aerolinea.persistence.entity.Modelo;
import com.aerolinea.aerolinea.persistence.repository.ModeloRepository;

@Service
public class ModeloService {

    private final ModeloRepository modeloRepository;
    private final ModeloMapper modeloMapper;

    public ModeloService(ModeloRepository modeloRepository, ModeloMapper modeloMapper) {
        this.modeloRepository = modeloRepository;
        this.modeloMapper = modeloMapper;
    }

    public ModeloDTO create(ModeloDTO modeloDTO) {
        Modelo modelo = modeloMapper.toDomain(modeloDTO);
        return modeloMapper.toDto(modeloRepository.save(modelo));
    }

    public List<ModeloDTO> getAll() {
        return modeloMapper.toLstDto(modeloRepository.findAll());
    }

    public void updateById(Long modId, ModeloDTO modeloDTO) {
        Optional<Modelo> findModeloById = modeloRepository.findById(modId);
        if (!findModeloById.isPresent()) {
            throw new Exception("Modelo Not Found", HttpStatus.NOT_FOUND);
        }
        Modelo updateModelo = findModeloById.get();
        updateModelo.setModNombre(modeloDTO.getModNombre());
        updateModelo.setModFUpdate(LocalDateTime.now());
        updateModelo.setModUUpdate("Piero");
        modeloRepository.save(updateModelo);
        throw new Exception("Modelo Update Successful", HttpStatus.OK);
    }

    public void deleteById(Long modId) {
        Optional<Modelo> findModeloById = modeloRepository.findById(modId);
        if (!findModeloById.isPresent()) {
            throw new Exception("Modelo Not Found", HttpStatus.NOT_FOUND);
        }
        modeloRepository.deleteById(modId);
        throw new Exception("Modelo Removed Successful", HttpStatus.OK);
    }

    public void deactivateByModId(Long modId) {
        Optional<Modelo> findModeloById = modeloRepository.findById(modId);
        if (!findModeloById.isPresent()) {
            throw new Exception("Modelo Not Found", HttpStatus.NOT_FOUND);
        }
        modeloRepository.deactivateByModId(modId);
        throw new Exception("Modelo Status : Disabled ", HttpStatus.OK);
    }

    public void activateByModId(Long modId) {
        Optional<Modelo> findModeloById = modeloRepository.findById(modId);
        if (!findModeloById.isPresent()) {
            throw new Exception("Modelo Not Found", HttpStatus.NOT_FOUND);
        }
        modeloRepository.activateByModId(modId);
        throw new Exception("Modelo Status : Activated ", HttpStatus.OK);
    }

    public List<ModeloDTO> getAllDeactivate() {
        return modeloMapper.toLstDto(modeloRepository.getAllDeactivate());
    }

    public List<ModeloDTO> getAllActivated() {
        return modeloMapper.toLstDto(modeloRepository.getAllActivated());
    }

}
