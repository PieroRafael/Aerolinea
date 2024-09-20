package com.aerolinea.aerolinea.service.Avion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.aerolinea.aerolinea.dto.Marca.Request.MarcaUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.Marca.Response.MarcaCreateResponseDTO;
import com.aerolinea.aerolinea.dto.Marca.Response.MarcaGetAllResponseDTO;
import com.aerolinea.aerolinea.exception.custom.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.aerolinea.aerolinea.dto.Marca.Request.MarcaCreateRequestDTO;
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

    public MarcaCreateResponseDTO create(MarcaCreateRequestDTO marcaCreateRequestDTO) {
        Marca marca = modelMapper.map(marcaCreateRequestDTO, Marca.class);
        marca.setMarFCreate(LocalDateTime.now());
        marca.setMarUCreate("Piero");
        return modelMapper.map(marcaRepository.save(marca) , MarcaCreateResponseDTO.class);
    }

    public List<MarcaGetAllResponseDTO> getAll() {
        List<Marca> lstMarca = marcaRepository.findAll();
        List<MarcaGetAllResponseDTO> lstMarcaGetAllResponseDTO = lstMarca.stream()
                .map(marca -> modelMapper.map(marca , MarcaGetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstMarcaGetAllResponseDTO;
    }

    public void updateById(Long marId, MarcaUpdateByIdRequestDTO marcaUpdateByIdRequestDTO) {
        Optional<Marca> findMarcaById = marcaRepository.findById(marId);
        if (!findMarcaById.isPresent()) {
            throw new ResourceNotFoundException("Marca Not Found");
        }
        Marca updateMarca = findMarcaById.get();
        updateMarca.setMarNombre(marcaUpdateByIdRequestDTO.getMarNombre());
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
