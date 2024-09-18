package com.aerolinea.aerolinea.service.Avion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.aerolinea.aerolinea.dto.Marca.Request.UpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.Marca.Response.CreateResponseDTO;
import com.aerolinea.aerolinea.exception.custom.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.aerolinea.aerolinea.dto.Marca.Request.CreateRequestDTO;
import com.aerolinea.aerolinea.persistence.entity.Avion.Marca;
import com.aerolinea.aerolinea.persistence.repository.Avion.MarcaRepository;

@Service
public class MarcaService {

    private final MarcaRepository marcaRepository;
    private final ModelMapper modelMapper;

    public MarcaService(MarcaRepository marcaRepository, ModelMapper modelMapper) {
        this.marcaRepository = marcaRepository;
        this.modelMapper = modelMapper;
    }

    public CreateResponseDTO create(CreateRequestDTO createRequestDTO) {
        Marca marca = modelMapper.map(createRequestDTO, Marca.class);
        marca.setMarFCreate(LocalDateTime.now());
        marca.setMarUCreate("Piero");
        return modelMapper.map(marcaRepository.save(marca) , CreateResponseDTO.class);
    }

    public List<CreateResponseDTO> getAll() {
        List<Marca> lstMarca = marcaRepository.findAll();
        List<CreateResponseDTO> lstCreateResponseDTO = lstMarca.stream()
                .map(marca -> modelMapper.map(marca , CreateResponseDTO.class))
                .collect(Collectors.toList());
        return lstCreateResponseDTO;
    }

    public void updateById(Long marId, UpdateByIdRequestDTO updateByIdRequestDTO) {
        Optional<Marca> findMarcaById = marcaRepository.findById(marId);
        if (!findMarcaById.isPresent()) {
            throw new ResourceNotFoundException("Marca Not Found");
        }
        Marca updateMarca = findMarcaById.get();
        updateMarca.setMarNombre(updateByIdRequestDTO.getMarNombre());
        updateMarca.setMarFUpdate(LocalDateTime.now());
        updateMarca.setMarUUpdate("Piero");
        marcaRepository.save(updateMarca);
    }

    public void deleteById(Long marId) {
        Optional<Marca> findMarcaById = marcaRepository.findById(marId);
        if (!findMarcaById.isPresent()) {
            throw new ResourceNotFoundException("Marca Not Found");
        }
        marcaRepository.deleteById(marId);
    }

}
