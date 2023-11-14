package com.aerolinea.aerolinea.service.Ruta;

import com.aerolinea.aerolinea.dto.PuntoEscala.PuntoEscalaDTO;
import com.aerolinea.aerolinea.exception.Exception;
import com.aerolinea.aerolinea.persistence.entity.Ruta.PuntoEscala;
import com.aerolinea.aerolinea.persistence.repository.Ruta.PuntoEscalaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PuntoEscalaService {

    private final PuntoEscalaRepository puntoEscalaRepository;

    private final ModelMapper modelMapper;

    public PuntoEscalaService(PuntoEscalaRepository puntoEscalaRepository,ModelMapper modelMapper){
        this.puntoEscalaRepository = puntoEscalaRepository;
        this.modelMapper = modelMapper;
    }

    public PuntoEscalaDTO create(PuntoEscalaDTO puntoEscalaDTO) {
        PuntoEscala puntoEscala = modelMapper.map(puntoEscalaDTO , PuntoEscala.class);
        puntoEscala.setPesFCreate(LocalDateTime.now());
        puntoEscala.setPesUCreate("Piero");
        return modelMapper.map(puntoEscalaRepository.save(puntoEscala) , PuntoEscalaDTO.class);
    }

    public List<PuntoEscalaDTO> getAll() {
        List<PuntoEscala> lstPuntoEscala = puntoEscalaRepository.findAll();
        List<PuntoEscalaDTO> lstPuntoEscalaDTO = lstPuntoEscala.stream()
                .map(puntoEscala -> modelMapper.map(puntoEscala,PuntoEscalaDTO.class))
                .collect(Collectors.toList());
        return lstPuntoEscalaDTO;
    }

    public void updateById(Long pesId, PuntoEscalaDTO puntoEscalaDTO) {
        Optional<PuntoEscala> findPuntoEscalaById = puntoEscalaRepository.findById(pesId);
        if (!findPuntoEscalaById.isPresent()) {
            throw new Exception("PuntoEscala Not Found", HttpStatus.NOT_FOUND);
        }
        PuntoEscala updatePuntoEscala = findPuntoEscalaById.get();
        updatePuntoEscala.setPesNombrePunto(puntoEscalaDTO.getPesNombrePunto());
        updatePuntoEscala.setPesLatitud(puntoEscalaDTO.getPesLatitud());
        updatePuntoEscala.setPesLongitud(puntoEscalaDTO.getPesLongitud());
        updatePuntoEscala.setPesFUpdate(LocalDateTime.now());
        updatePuntoEscala.setPesUUpdate("Piero");
        puntoEscalaRepository.save(updatePuntoEscala);
        throw new Exception("PuntoEscala Update Successful", HttpStatus.OK);
    }

    public void deleteById(Long pesId) {
        Optional<PuntoEscala> findPuntoEscalaById = puntoEscalaRepository.findById(pesId);
        if (!findPuntoEscalaById.isPresent()) {
            throw new Exception("PuntoEscala Not Found", HttpStatus.NOT_FOUND);
        }
        puntoEscalaRepository.deleteById(pesId);
        throw new Exception("PuntoEscala Removed Successful", HttpStatus.OK);
    }

}
