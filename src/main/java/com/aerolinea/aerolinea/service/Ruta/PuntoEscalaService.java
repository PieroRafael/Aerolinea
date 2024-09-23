package com.aerolinea.aerolinea.service.Ruta;

import com.aerolinea.aerolinea.dto.PuntoEscala.Request.PuntoEscalaCreateRequestDTO;
import com.aerolinea.aerolinea.dto.PuntoEscala.Request.PuntoEscalaUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.PuntoEscala.Response.PuntoEscalaCreateResponseDTO;
import com.aerolinea.aerolinea.dto.PuntoEscala.Response.PuntoEscalaGetAllResponseDTO;
import com.aerolinea.aerolinea.exception.custom.ResourceNotFoundException;
import com.aerolinea.aerolinea.persistence.entity.Ruta.PuntoEscala;
import com.aerolinea.aerolinea.persistence.repository.Ruta.PuntoEscalaRepository;
import org.modelmapper.ModelMapper;
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

    public PuntoEscalaCreateResponseDTO create(PuntoEscalaCreateRequestDTO puntoEscalaCreateRequestDTO) {
        PuntoEscala puntoEscala = modelMapper.map(puntoEscalaCreateRequestDTO, PuntoEscala.class);
        puntoEscala.setPesFCreate(LocalDateTime.now());
        puntoEscala.setPesUCreate("Piero");
        return modelMapper.map(puntoEscalaRepository.save(puntoEscala) , PuntoEscalaCreateResponseDTO.class);
    }

    public List<PuntoEscalaGetAllResponseDTO> getAll() {
        List<PuntoEscala> lstPuntoEscala = puntoEscalaRepository.findAll();
        List<PuntoEscalaGetAllResponseDTO> lstPuntoEscalaGetAllResponseDTO = lstPuntoEscala.stream()
                .map(puntoEscala -> modelMapper.map(puntoEscala, PuntoEscalaGetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstPuntoEscalaGetAllResponseDTO;
    }

    public void updateById(Long pesId, PuntoEscalaUpdateByIdRequestDTO puntoEscalaUpdateByIdRequestDTO) {
        Optional<PuntoEscala> findPuntoEscalaById = puntoEscalaRepository.findById(pesId);
        if (!findPuntoEscalaById.isPresent()) {
            throw new ResourceNotFoundException("PuntoEscala Not Found");
        }
        PuntoEscala updatePuntoEscala = findPuntoEscalaById.get();
        updatePuntoEscala.setPesNombrePunto(puntoEscalaUpdateByIdRequestDTO.getPesNombrePunto());
        updatePuntoEscala.setPesLatitud(puntoEscalaUpdateByIdRequestDTO.getPesLatitud());
        updatePuntoEscala.setPesLongitud(puntoEscalaUpdateByIdRequestDTO.getPesLongitud());
        updatePuntoEscala.setPesFUpdate(LocalDateTime.now());
        updatePuntoEscala.setPesUUpdate("Piero");
        puntoEscalaRepository.save(updatePuntoEscala);
    }

    public void deleteById(Long pesId) {
        Optional<PuntoEscala> findPuntoEscalaById = puntoEscalaRepository.findById(pesId);
        if (!findPuntoEscalaById.isPresent()) {
            throw new ResourceNotFoundException("PuntoEscala Not Found");
        }
        puntoEscalaRepository.deleteById(pesId);
    }

}
