package com.aerolinea.aerolinea.service.Ruta;

import com.aerolinea.aerolinea.dto.Ruta.Request.RutaCreateRequestDTO;
import com.aerolinea.aerolinea.dto.Ruta.Request.RutaUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.Ruta.Response.RutaCreateResponseDTO;
import com.aerolinea.aerolinea.dto.Ruta.Response.RutaGetAllResponseDTO;
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

    public RutaCreateResponseDTO create(RutaCreateRequestDTO rutaCreateRequestDTO) {
        Ruta ruta = modelMapper.map(rutaCreateRequestDTO, Ruta.class);
        ruta.setRtaFCreate(LocalDateTime.now());
        ruta.setRtaUCreate("Piero");
        return modelMapper.map(rutaRepository.save(ruta) , RutaCreateResponseDTO.class);
    }

    public List<RutaGetAllResponseDTO> getAll() {
        List<Ruta> lstRuta = rutaRepository.findAll();
        List<RutaGetAllResponseDTO> lstRutaGetAllResponseDTO = lstRuta.stream()
                .map(ruta -> modelMapper.map(ruta, RutaGetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstRutaGetAllResponseDTO;
    }

    public void updateById(Long rtaId, RutaUpdateByIdRequestDTO rutaUpdateByIdRequestDTO) {
        Optional<Ruta> findRutaById = rutaRepository.findById(rtaId);
        if (!findRutaById.isPresent()) {
            throw new ResourceNotFoundException("Ruta Not Found");
        }
        Ruta updateRuta = findRutaById.get();
        updateRuta.setRtaNombre(rutaUpdateByIdRequestDTO.getRtaNombre());
        updateRuta.setRtaPromedioMinutos(rutaUpdateByIdRequestDTO.getRtaPromedioMinutos());
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
