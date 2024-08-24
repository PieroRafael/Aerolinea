package com.aerolinea.aerolinea.service.Ruta;

import com.aerolinea.aerolinea.dto.Ruta.RutaDTO;
import com.aerolinea.aerolinea.exception.custom.ResourceNotFoundException;
import com.aerolinea.aerolinea.persistence.entity.Ruta.Ruta;
import com.aerolinea.aerolinea.persistence.repository.Ruta.RutaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RutaService {

    private final RutaRepository rutaRepository;

    private final ModelMapper modelMapper;

    public RutaService(RutaRepository rutaRepository,ModelMapper modelMapper){
        this.rutaRepository = rutaRepository;
        this.modelMapper = modelMapper;
    }

    public RutaDTO create(RutaDTO rutaDTO) {
        Ruta ruta = modelMapper.map(rutaDTO , Ruta.class);
        ruta.setRtaFCreate(LocalDateTime.now());
        ruta.setRtaUCreate("Piero");
        return modelMapper.map(rutaRepository.save(ruta) , RutaDTO.class);
    }

    public List<RutaDTO> getAll() {
        List<Ruta> lstRuta = rutaRepository.findAll();
        List<RutaDTO> lstRutaDTO = lstRuta.stream()
                .map(ruta -> modelMapper.map(ruta,RutaDTO.class))
                .collect(Collectors.toList());
        return lstRutaDTO;
    }

    public void updateById(Long rtaId, RutaDTO rutaDTO) {
        Optional<Ruta> findRutaById = rutaRepository.findById(rtaId);
        if (!findRutaById.isPresent()) {
            throw new ResourceNotFoundException("Ruta Not Found");
        }
        Ruta updateRuta = findRutaById.get();
        updateRuta.setRtaNombre(rutaDTO.getRtaNombre());
        updateRuta.setRtaPromedioMinutos(rutaDTO.getRtaPromedioMinutos());
        updateRuta.setRtaFUpdate(LocalDateTime.now());
        updateRuta.setRtaUUpdate("Piero");
        rutaRepository.save(updateRuta);
    }

    public void deleteById(Long rtaId) {
        Optional<Ruta> findRutaById = rutaRepository.findById(rtaId);
        if (!findRutaById.isPresent()) {
            throw new ResourceNotFoundException("Ruta Not Found");
        }
        rutaRepository.deleteById(rtaId);
    }

}
