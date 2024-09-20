package com.aerolinea.aerolinea.service.Avion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.aerolinea.aerolinea.dto.Modelo.Request.ModeloUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.Modelo.Response.ModeloCreateResponseDTO;
import com.aerolinea.aerolinea.dto.Modelo.Response.ModeloGetAllResponseDTO;
import com.aerolinea.aerolinea.exception.custom.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.aerolinea.aerolinea.dto.Modelo.Request.ModeloCreateRequestDTO;
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

    public ModeloCreateResponseDTO create(ModeloCreateRequestDTO modeloCreateRequestDTO) {
        Modelo modelo = modelMapper.map(modeloCreateRequestDTO, Modelo.class);
        modelo.setModFCreate(LocalDateTime.now());
        modelo.setModUCreate("Piero");
        return modelMapper.map(modeloRepository.save(modelo) , ModeloCreateResponseDTO.class);
    }

   public List<ModeloGetAllResponseDTO> getAll() {
        List<Modelo> lstModelo = modeloRepository.findAll();
        List<ModeloGetAllResponseDTO> lstModeloGetAllResponseDTO = lstModelo.stream()
                .map(modelo -> modelMapper.map(modelo, ModeloGetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstModeloGetAllResponseDTO;
    }

    public void updateById(Long modId, ModeloUpdateByIdRequestDTO modeloUpdateByIdRequestDTO) {
        Optional<Modelo> findModeloById = modeloRepository.findById(modId);
        if (!findModeloById.isPresent()) {
            throw new ResourceNotFoundException("Modelo Not Found");
        }
        Modelo updateModelo = findModeloById.get();
        updateModelo.setModNombre(modeloUpdateByIdRequestDTO.getModNombre());
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
