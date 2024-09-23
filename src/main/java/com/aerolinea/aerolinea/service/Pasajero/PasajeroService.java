package com.aerolinea.aerolinea.service.Pasajero;

import com.aerolinea.aerolinea.dto.Pasajero.Request.PasajeroCreateRequestDTO;
import com.aerolinea.aerolinea.dto.Pasajero.Request.PasajeroUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.Pasajero.Response.PasajeroCreateResponseDTO;
import com.aerolinea.aerolinea.dto.Pasajero.Response.PasajeroGetAllResponseDTO;
import com.aerolinea.aerolinea.exception.custom.ResourceNotFoundException;
import com.aerolinea.aerolinea.persistence.entity.Pasajero.Genero;
import com.aerolinea.aerolinea.persistence.entity.Pasajero.Pasajero;
import com.aerolinea.aerolinea.persistence.repository.Pasajero.PasajeroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PasajeroService {

    private final PasajeroRepository pasajeroRepository;

    private final ModelMapper modelMapper;

    public PasajeroService(PasajeroRepository pasajeroRepository,ModelMapper modelMapper){
        this.pasajeroRepository = pasajeroRepository;
        this.modelMapper = modelMapper;
    }

    public PasajeroCreateResponseDTO create(PasajeroCreateRequestDTO pasajeroCreateRequestDTO) {
        Pasajero pasajero = modelMapper.map(pasajeroCreateRequestDTO,Pasajero.class);
        pasajero.setPasGenero(Genero.valueOf(pasajeroCreateRequestDTO.getPasGenero().toUpperCase()));
        pasajero.setPasFCreate(LocalDateTime.now());
        pasajero.setPasUCreate("Piero");
        return modelMapper.map(pasajeroRepository.save(pasajero), PasajeroCreateResponseDTO.class);
    }

    public List<PasajeroGetAllResponseDTO> getAll() {
        List<Pasajero> lstPasajero = pasajeroRepository.findAll();
        List<PasajeroGetAllResponseDTO> lstPasajeroGetAllResponseDTO = lstPasajero.stream()
                .map(pasajero -> modelMapper.map(pasajero, PasajeroGetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstPasajeroGetAllResponseDTO;
    }

    public void updateById(Long pasId, PasajeroUpdateByIdRequestDTO pasajeroUpdateByIdRequestDTO) {
        Optional<Pasajero> findPasajeroById = pasajeroRepository.findById(pasId);
        if (!findPasajeroById.isPresent()) {
            throw new ResourceNotFoundException("Pasajero Not Found");
        }
        Pasajero updatePasajero = findPasajeroById.get();
        updatePasajero.setPasNombre(pasajeroUpdateByIdRequestDTO.getPasNombre());
        updatePasajero.setPasApellido(pasajeroUpdateByIdRequestDTO.getPasApellido());
        updatePasajero.setPasEdad(pasajeroUpdateByIdRequestDTO.getPasEdad());
        updatePasajero.setPasGenero(Genero.valueOf(pasajeroUpdateByIdRequestDTO.getPasGenero().toUpperCase()));
        updatePasajero.setPasFUpdate(LocalDateTime.now());
        updatePasajero.setPasUUpdate("Piero");
        pasajeroRepository.save(updatePasajero);
    }

    public void deleteById(Long pasId) {
        Optional<Pasajero> findPasajeroById = pasajeroRepository.findById(pasId);
        if (!findPasajeroById.isPresent()) {
            throw new ResourceNotFoundException("Pasajero Not Found");
        }
        pasajeroRepository.deleteById(pasId);
    }

}
