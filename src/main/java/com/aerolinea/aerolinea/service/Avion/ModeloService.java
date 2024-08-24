package com.aerolinea.aerolinea.service.Avion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.aerolinea.aerolinea.exception.custom.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.aerolinea.aerolinea.dto.Modelo.ModeloDTO;
import com.aerolinea.aerolinea.persistence.entity.Avion.Modelo;
import com.aerolinea.aerolinea.persistence.repository.Avion.ModeloRepository;

@Service
public class ModeloService {

    private final ModeloRepository modeloRepository;
    private final ModelMapper modelMapper;

    public ModeloService(ModeloRepository modeloRepository , ModelMapper modelMapper) {
        this.modeloRepository = modeloRepository;
        this.modelMapper = modelMapper;
    }

    public ModeloDTO create(ModeloDTO modeloDTO) {
        Modelo modelo = modelMapper.map(modeloDTO, Modelo.class); //Dto a Entidad
        modelo.setModFCreate(LocalDateTime.now());
        modelo.setModUCreate("Piero");
        return modelMapper.map(modeloRepository.save(modelo) , ModeloDTO.class); //Entidad a DTO
    }

   public List<ModeloDTO> getAll() {
        List<Modelo> lstModelo = modeloRepository.findAll();
        List<ModeloDTO> lstModeloDTO = lstModelo.stream()
                .map(modelo -> modelMapper.map(modelo,ModeloDTO.class))
                .collect(Collectors.toList());
        return lstModeloDTO;
    }

    public void updateById(Long modId, ModeloDTO modeloDTO) {
        Optional<Modelo> findModeloById = modeloRepository.findById(modId);
        if (!findModeloById.isPresent()) {
            throw new ResourceNotFoundException("Modelo Not Found");
        }
        Modelo updateModelo = findModeloById.get();
        updateModelo.setModNombre(modeloDTO.getModNombre());
        updateModelo.setModFUpdate(LocalDateTime.now());
        updateModelo.setModUUpdate("Piero");
        modeloRepository.save(updateModelo);
    }


    public void deleteById(Long modId) {
        Optional<Modelo> findModeloById = modeloRepository.findById(modId);
        if (!findModeloById.isPresent()) {
            throw new ResourceNotFoundException("Modelo Not Found");
        }
        modeloRepository.deleteById(modId);
    }

}
