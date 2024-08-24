package com.aerolinea.aerolinea.service.Ruta;

import com.aerolinea.aerolinea.dto.PuntoRuta.PuntoRutaListDTO;
import com.aerolinea.aerolinea.dto.PuntoRuta.PuntoRutaSaveDTO;
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

    public PuntoRutaSaveDTO create(PuntoRutaSaveDTO puntoRutaSaveDTO) {
        PuntoRuta puntoRuta = modelMapper.map(puntoRutaSaveDTO , PuntoRuta.class);
        puntoRuta.setPtrFCreate(LocalDateTime.now());
        puntoRuta.setPtrUCreate("Piero");
        return modelMapper.map(puntoRutaRepository.save(puntoRuta) , PuntoRutaSaveDTO.class);
    }

    public List<PuntoRutaListDTO> getAll() {
        List<PuntoRuta> lstPuntoRuta = puntoRutaRepository.findAll();
        List<PuntoRutaListDTO> lstPuntoRutaDTO = lstPuntoRuta.stream()
                .map(puntoRuta -> modelMapper.map(puntoRuta,PuntoRutaListDTO.class))
                .collect(Collectors.toList());
        return lstPuntoRutaDTO;
    }

    public void updateById(Long ptrId, PuntoRutaSaveDTO puntoRutaSaveDTO) {
        Optional<PuntoRuta> findPuntoRutaById = puntoRutaRepository.findById(ptrId);
        if (!findPuntoRutaById.isPresent()) {
            throw new ResourceNotFoundException("PuntoRuta Not Found");
        }
        PuntoRuta updatePuntoRuta = findPuntoRutaById.get();
        updatePuntoRuta.setPtrOrden(puntoRutaSaveDTO.getPtrOrden());
        updatePuntoRuta.setRuta(Ruta.builder().rtaId(puntoRutaSaveDTO.getRtaId()).build());
        updatePuntoRuta.setPuntoEscala(PuntoEscala.builder().pesId(puntoRutaSaveDTO.getPesId()).build());
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
