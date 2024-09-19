package com.aerolinea.aerolinea.service.Avion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.aerolinea.aerolinea.dto.Modelo.Request.UpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.Modelo.Response.CreateResponseDTO;
import com.aerolinea.aerolinea.dto.Modelo.Response.GetAllResponseDTO;
import com.aerolinea.aerolinea.exception.custom.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.aerolinea.aerolinea.dto.Modelo.Request.CreateRequestDTO;
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

    public CreateResponseDTO create(CreateRequestDTO createRequestDTO) {
        Modelo modelo = modelMapper.map(createRequestDTO, Modelo.class);
        modelo.setModFCreate(LocalDateTime.now());
        modelo.setModUCreate("Piero");
        return modelMapper.map(modeloRepository.save(modelo) , CreateResponseDTO.class);
    }

   public List<GetAllResponseDTO> getAll() {
        List<Modelo> lstModelo = modeloRepository.findAll();
        List<GetAllResponseDTO> lstGetAllResponseDTO = lstModelo.stream()
                .map(modelo -> modelMapper.map(modelo, GetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstGetAllResponseDTO;
    }

    public void updateById(Long modId, UpdateByIdRequestDTO updateByIdRequestDTO) {
        Optional<Modelo> findModeloById = modeloRepository.findById(modId);
        if (!findModeloById.isPresent()) {
            throw new ResourceNotFoundException("Modelo Not Found");
        }
        Modelo updateModelo = findModeloById.get();
        updateModelo.setModNombre(updateByIdRequestDTO.getModNombre());
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
