package com.aerolinea.aerolinea.service.Tripulacion;

import com.aerolinea.aerolinea.dto.Tripulacion.Request.TripulacionUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.Tripulacion.Response.TripulacionCreateResponseDTO;
import com.aerolinea.aerolinea.dto.Tripulacion.Response.TripulacionGetAllResponseDTO;
import com.aerolinea.aerolinea.dto.Tripulacion.Request.TripulacionCreateRequestDTO;
import com.aerolinea.aerolinea.exception.custom.ResourceNotFoundException;
import com.aerolinea.aerolinea.persistence.entity.Tripulacion.CargoTripulante;
import com.aerolinea.aerolinea.persistence.entity.Tripulacion.Tripulacion;
import com.aerolinea.aerolinea.persistence.repository.Tripulacion.TripulacionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TripulacionService {

    private final TripulacionRepository tripulacionRepository;

    private final ModelMapper modelMapper;

    public TripulacionService(TripulacionRepository tripulacionRepository,ModelMapper modelMapper){
        this.tripulacionRepository = tripulacionRepository;
        this.modelMapper = modelMapper;
    }

    public TripulacionCreateResponseDTO create(TripulacionCreateRequestDTO tripulacionCreateRequestDTO) {
        Tripulacion tripulacion = modelMapper.map(tripulacionCreateRequestDTO, Tripulacion.class);
        tripulacion.setTriCodigo(String.valueOf(UUID.randomUUID()));
        tripulacion.setTriFCreate(LocalDateTime.now());
        tripulacion.setTriUCreate("Piero");
        return modelMapper.map(tripulacionRepository.save(tripulacion), TripulacionCreateResponseDTO.class);
    }

    public List<TripulacionGetAllResponseDTO> getAll() {
        List<Tripulacion> lstTripulacion = tripulacionRepository.findAll();
        List<TripulacionGetAllResponseDTO> lstTripulacionDTO = lstTripulacion.stream()
                .map(tripulacion -> modelMapper.map(tripulacion, TripulacionGetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstTripulacionDTO;
    }

    public void updateById(Long triId, TripulacionUpdateByIdRequestDTO tripulacionUpdateByIdRequestDTO) {
        Optional<Tripulacion> findTripulacionById = tripulacionRepository.findById(triId);
        if (!findTripulacionById.isPresent()) {
            throw new ResourceNotFoundException("Tripulacion Not Found");
        }
        Tripulacion updateTripulacion = findTripulacionById.get();
        updateTripulacion.setTriNombre(tripulacionUpdateByIdRequestDTO.getTriNombre());
        updateTripulacion.setTriApellido(tripulacionUpdateByIdRequestDTO.getTriApellido());
        updateTripulacion.setCargoTripulante(CargoTripulante.builder().catId(tripulacionUpdateByIdRequestDTO.getCatId()).build());
        updateTripulacion.setTriFUpdate(LocalDateTime.now());
        updateTripulacion.setTriUUpdate("Piero");
        tripulacionRepository.save(updateTripulacion);
    }

    public void deleteById(Long triId) {
        Optional<Tripulacion> findTripulacionById = tripulacionRepository.findById(triId);
        if (!findTripulacionById.isPresent()) {
            throw new ResourceNotFoundException("Tripulacion Not Found");
        }
        tripulacionRepository.deleteById(triId);
    }

}
