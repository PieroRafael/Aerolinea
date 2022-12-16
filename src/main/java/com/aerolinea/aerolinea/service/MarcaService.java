package com.aerolinea.aerolinea.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.aerolinea.aerolinea.dto.MarcaDTO;
import com.aerolinea.aerolinea.exception.Exception;
import com.aerolinea.aerolinea.mapper.MarcaMapper;
import com.aerolinea.aerolinea.persistence.entity.Marca;
import com.aerolinea.aerolinea.persistence.repository.MarcaRepository;

@Service
public class MarcaService {

    private final MarcaRepository marcaRepository;
    private final MarcaMapper marcaMapper;

    public MarcaService(MarcaRepository marcaRepository, MarcaMapper marcaMapper) {
        this.marcaRepository = marcaRepository;
        this.marcaMapper = marcaMapper;
    }

    public MarcaDTO create(MarcaDTO marcaDTO) {
        Marca marca = marcaMapper.toDomain(marcaDTO);
        return marcaMapper.toDto(marcaRepository.save(marca));
    }

    public List<MarcaDTO> getAll() {
        return marcaMapper.toLstDto(marcaRepository.findAll());
    }

    public void updateById(Long marId, MarcaDTO marcaDTO) {
        Optional<Marca> findMarcaById = marcaRepository.findById(marId);
        if (!findMarcaById.isPresent()) {
            throw new Exception("Marca Not Found", HttpStatus.NOT_FOUND);
        }
        Marca updateMarca = findMarcaById.get();
        updateMarca.setMarNombre(marcaDTO.getMarNombre());
        updateMarca.setMarFUpdate(LocalDateTime.now());
        updateMarca.setMarUUpdate("Piero");
        marcaRepository.save(updateMarca);
        throw new Exception("Marca Update Successful", HttpStatus.OK);
    }

    public void deleteById(Long marId) {
        Optional<Marca> findMarcaById = marcaRepository.findById(marId);
        if (!findMarcaById.isPresent()) {
            throw new Exception("Marca Not Found", HttpStatus.NOT_FOUND);
        }
        marcaRepository.deleteById(marId);
        throw new Exception("Marca Removed Successful", HttpStatus.OK);
    }

    public void deactivateByMarId(Long marId) {
        Optional<Marca> findMarcaById = marcaRepository.findById(marId);
        if (!findMarcaById.isPresent()) {
            throw new Exception("Marca Not Found", HttpStatus.NOT_FOUND);
        }
        marcaRepository.deactivateByMarId(marId);
        throw new Exception("Marca Status : Disabled ", HttpStatus.OK);
    }

    public void activateByMarId(Long marId) {
        Optional<Marca> findMarcaById = marcaRepository.findById(marId);
        if (!findMarcaById.isPresent()) {
            throw new Exception("Marca Not Found", HttpStatus.NOT_FOUND);
        }
        marcaRepository.activateByMarId(marId);
        throw new Exception("Marca Status : Activated ", HttpStatus.OK);
    }

    public List<MarcaDTO> getAllDeactivate() {
        return marcaMapper.toLstDto(marcaRepository.getAllDeactivate());
    }

    public List<MarcaDTO> getAllActivated() {
        return marcaMapper.toLstDto(marcaRepository.getAllActivated());
    }

}
