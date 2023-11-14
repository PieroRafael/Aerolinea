package com.aerolinea.aerolinea.service.Tripulacion;

import com.aerolinea.aerolinea.dto.TripulacionVuelo.TripulacionVueloListDTO;
import com.aerolinea.aerolinea.dto.TripulacionVuelo.TripulacionVueloSaveDTO;
import com.aerolinea.aerolinea.exception.Exception;
import com.aerolinea.aerolinea.persistence.entity.Tripulacion.Tripulacion;
import com.aerolinea.aerolinea.persistence.entity.Tripulacion.TripulacionVuelo;
import com.aerolinea.aerolinea.persistence.entity.Vuelo.Vuelo;
import com.aerolinea.aerolinea.persistence.repository.Tripulacion.TripulacionVueloRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TripulacionVueloService {

    private final TripulacionVueloRepository tripulacionVueloRepository;

    private final ModelMapper modelMapper;

    public TripulacionVueloService(TripulacionVueloRepository tripulacionVueloRepository,ModelMapper modelMapper){
        this.tripulacionVueloRepository = tripulacionVueloRepository;
        this.modelMapper = modelMapper;
    }

    public TripulacionVueloSaveDTO create(TripulacionVueloSaveDTO tripulacionVueloSaveDTO) {
        TripulacionVuelo tripulacionVuelo= modelMapper.map(tripulacionVueloSaveDTO, TripulacionVuelo.class);
        tripulacionVuelo.setTvuFCreate(LocalDateTime.now());
        tripulacionVuelo.setTvuUCreate("Piero");
        return modelMapper.map(tripulacionVueloRepository.save(tripulacionVuelo),TripulacionVueloSaveDTO.class);
    }

    public List<TripulacionVueloListDTO> getAll() {
        List<TripulacionVuelo> lstTripulacionVuelo = tripulacionVueloRepository.findAll();
        List<TripulacionVueloListDTO> lstTripulacionVueloDTO = lstTripulacionVuelo.stream()
                .map(tripulacionVuelo -> modelMapper.map(tripulacionVuelo,TripulacionVueloListDTO.class))
                .collect(Collectors.toList());
        return lstTripulacionVueloDTO;
    }

    public void updateById(Long tvuId, TripulacionVueloSaveDTO tripulacionVueloSaveDTO) {
        Optional<TripulacionVuelo> findTripulacionVueloById = tripulacionVueloRepository.findById(tvuId);
        if (!findTripulacionVueloById.isPresent()) {
            throw new Exception("TripulacionVuelo Not Found", HttpStatus.NOT_FOUND);
        }
        TripulacionVuelo updateTripulacionVuelo = findTripulacionVueloById.get();
        updateTripulacionVuelo.setVuelo(Vuelo.builder().vueId(tripulacionVueloSaveDTO.getVueId()).build());
        updateTripulacionVuelo.setTripulacion(Tripulacion.builder().triId(tripulacionVueloSaveDTO.getTriId()).build());
        updateTripulacionVuelo.setTvuFUpdate(LocalDateTime.now());
        updateTripulacionVuelo.setTvuUUpdate("Piero");
        tripulacionVueloRepository.save(updateTripulacionVuelo);
        throw new Exception("TripulacionVuelo Update Successful", HttpStatus.OK);
    }

    public void deleteById(Long tvuId) {
        Optional<TripulacionVuelo> findTripulacionVueloById = tripulacionVueloRepository.findById(tvuId);
        if (!findTripulacionVueloById.isPresent()) {
            throw new Exception("TripulacionVuelo Not Found", HttpStatus.NOT_FOUND);
        }
        tripulacionVueloRepository.deleteById(tvuId);
        throw new Exception("TripulacionVuelo Removed Successful", HttpStatus.OK);
    }

}
