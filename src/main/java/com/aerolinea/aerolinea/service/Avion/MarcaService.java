package com.aerolinea.aerolinea.service.Avion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.aerolinea.aerolinea.exception.custom.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.aerolinea.aerolinea.dto.Marca.MarcaDTO;
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

    public MarcaDTO create(MarcaDTO marcaDTO) {
        Marca marca = modelMapper.map(marcaDTO , Marca.class);
        marca.setMarFCreate(LocalDateTime.now());
        marca.setMarUCreate("Piero");
        return modelMapper.map(marcaRepository.save(marca) , MarcaDTO.class);
    }

    public List<MarcaDTO> getAll() {
        List<Marca> lstMarca = marcaRepository.findAll();
        List<MarcaDTO> lstMarcaDTO = lstMarca.stream()
                .map(marca -> modelMapper.map(marca , MarcaDTO.class))
                .collect(Collectors.toList());
        return lstMarcaDTO;
    }

    public void updateById(Long marId, MarcaDTO marcaDTO) {
        Optional<Marca> findMarcaById = marcaRepository.findById(marId);
        if (!findMarcaById.isPresent()) {
            throw new ResourceNotFoundException("Marca Not Found");
        }
        Marca updateMarca = findMarcaById.get();
        updateMarca.setMarNombre(marcaDTO.getMarNombre());
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
