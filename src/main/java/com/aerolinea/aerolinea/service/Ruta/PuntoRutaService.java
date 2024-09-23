package com.aerolinea.aerolinea.service.Ruta;

import com.aerolinea.aerolinea.dto.PuntoRuta.Request.PuntoRutaUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.PuntoRuta.Response.PuntoRutaCreateResponseDTO;
import com.aerolinea.aerolinea.dto.PuntoRuta.Response.PuntoRutaGetAllResponseDTO;
import com.aerolinea.aerolinea.dto.PuntoRuta.Request.PuntoRutaCreateRequestDTO;
import com.aerolinea.aerolinea.exception.custom.ResourceNotFoundException;
import com.aerolinea.aerolinea.persistence.entity.Ruta.PuntoEscala;
import com.aerolinea.aerolinea.persistence.entity.Ruta.PuntoRuta;
import com.aerolinea.aerolinea.persistence.entity.Ruta.Ruta;
import com.aerolinea.aerolinea.persistence.repository.Ruta.PuntoRutaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PuntoRutaService {

    private final PuntoRutaRepository puntoRutaRepository;

    private final ModelMapper modelMapper;

    public PuntoRutaService (PuntoRutaRepository puntoRutaRepository,ModelMapper modelMapper){
        this.puntoRutaRepository = puntoRutaRepository;
        this.modelMapper = modelMapper;
    }

    public PuntoRutaCreateResponseDTO create(PuntoRutaCreateRequestDTO puntoRutaCreateRequestDTO) {
        PuntoRuta puntoRuta = modelMapper.map(puntoRutaCreateRequestDTO, PuntoRuta.class);
        puntoRuta.setPtrFCreate(LocalDateTime.now());
        puntoRuta.setPtrUCreate("Piero");
        return modelMapper.map(puntoRutaRepository.save(puntoRuta) , PuntoRutaCreateResponseDTO.class);
    }

    public List<PuntoRutaGetAllResponseDTO> getAll() {
        List<PuntoRuta> lstPuntoRuta = puntoRutaRepository.findAll();
        List<PuntoRutaGetAllResponseDTO> lstPuntoRutaDTO = lstPuntoRuta.stream()
                .map(puntoRuta -> modelMapper.map(puntoRuta, PuntoRutaGetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstPuntoRutaDTO;
    }

    public void updateById(Long ptrId, PuntoRutaUpdateByIdRequestDTO puntoRutaUpdateByIdRequestDTO) {
        Optional<PuntoRuta> findPuntoRutaById = puntoRutaRepository.findById(ptrId);
        if (!findPuntoRutaById.isPresent()) {
            throw new ResourceNotFoundException("PuntoRuta Not Found");
        }
        PuntoRuta updatePuntoRuta = findPuntoRutaById.get();
        updatePuntoRuta.setPtrOrden(puntoRutaUpdateByIdRequestDTO.getPtrOrden());
        updatePuntoRuta.setRuta(Ruta.builder().rtaId(puntoRutaUpdateByIdRequestDTO.getRtaId()).build());
        updatePuntoRuta.setPuntoEscala(PuntoEscala.builder().pesId(puntoRutaUpdateByIdRequestDTO.getPesId()).build());
        puntoRutaRepository.save(updatePuntoRuta);
    }

    public void deleteById(Long ptrId) {
        Optional<PuntoRuta> findPuntoRutaById = puntoRutaRepository.findById(ptrId);
        if (!findPuntoRutaById.isPresent()) {
            throw new ResourceNotFoundException("PuntoRuta Not Found");
        }
        puntoRutaRepository.deleteById(ptrId);
    }
}
