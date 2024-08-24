package com.aerolinea.aerolinea.service.Pasajero;

import com.aerolinea.aerolinea.dto.Pasajero.PasajeroDTO;
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

    public PasajeroDTO create(PasajeroDTO pasajeroDTO) {
        Pasajero pasajero = modelMapper.map(pasajeroDTO,Pasajero.class);
        pasajero.setPasGenero(Genero.valueOf(pasajeroDTO.getPasGenero().toUpperCase()));
        pasajero.setPasFCreate(LocalDateTime.now());
        pasajero.setPasUCreate("Piero");
        return modelMapper.map(pasajeroRepository.save(pasajero),PasajeroDTO.class);
    }

    public List<PasajeroDTO> getAll() {
        List<Pasajero> lstPasajero = pasajeroRepository.findAll();
        List<PasajeroDTO> lstPasajeroDTO = lstPasajero.stream()
                .map(pasajero -> modelMapper.map(pasajero,PasajeroDTO.class))
                .collect(Collectors.toList());
        return lstPasajeroDTO;
    }

    public void updateById(Long pasId, PasajeroDTO pasajeroDTO) {
        Optional<Pasajero> findPasajeroById = pasajeroRepository.findById(pasId);
        if (!findPasajeroById.isPresent()) {
            throw new ResourceNotFoundException("Pasajero Not Found");
        }
        Pasajero updatePasajero = findPasajeroById.get();
        updatePasajero.setPasNombre(pasajeroDTO.getPasNombre());
        updatePasajero.setPasApellido(pasajeroDTO.getPasApellido());
        updatePasajero.setPasEdad(pasajeroDTO.getPasEdad());
        updatePasajero.setPasGenero(Genero.valueOf(pasajeroDTO.getPasGenero().toUpperCase()));
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
