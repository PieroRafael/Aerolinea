package com.aerolinea.aerolinea.service.Tripulacion;

import com.aerolinea.aerolinea.dto.CargoTripulante.Request.CargoTripulanteCreateRequestDTO;
import com.aerolinea.aerolinea.dto.CargoTripulante.Request.CargoTripulanteUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.CargoTripulante.Response.CargoTripulanteCreateResponseDTO;
import com.aerolinea.aerolinea.dto.CargoTripulante.Response.CargoTripulanteGetAllResponseDTO;
import com.aerolinea.aerolinea.exception.custom.ResourceNotFoundException;
import com.aerolinea.aerolinea.persistence.entity.Tripulacion.CargoTripulante;
import com.aerolinea.aerolinea.persistence.repository.Tripulacion.CargoTripulanteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CargoTripulanteService {

    private final CargoTripulanteRepository cargoTripulanteRepository;

    private final ModelMapper modelMapper;

    public CargoTripulanteService(CargoTripulanteRepository cargoTripulanteRepository,ModelMapper modelMapper){
        this.cargoTripulanteRepository = cargoTripulanteRepository;
        this.modelMapper = modelMapper;
    }

    public CargoTripulanteCreateResponseDTO create(CargoTripulanteCreateRequestDTO cargoTripulanteCreateRequestDTO) {
        CargoTripulante cargoTripulante = modelMapper.map(cargoTripulanteCreateRequestDTO, CargoTripulante.class);
        cargoTripulante.setCatFCreate(LocalDateTime.now());
        cargoTripulante.setCatUCreate("Piero");
        return modelMapper.map(cargoTripulanteRepository.save(cargoTripulante), CargoTripulanteCreateResponseDTO.class);
    }

    public List<CargoTripulanteGetAllResponseDTO> getAll() {
        List<CargoTripulante> lstCargoTripulante = cargoTripulanteRepository.findAll();
        List<CargoTripulanteGetAllResponseDTO> lstCargoTripulanteGetAllResponseDTO = lstCargoTripulante.stream()
                .map(cargoTripulante -> modelMapper.map(cargoTripulante, CargoTripulanteGetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstCargoTripulanteGetAllResponseDTO;
    }

    public void updateById(Long catId, CargoTripulanteUpdateByIdRequestDTO cargoTripulanteUpdateByIdRequestDTO) {
        Optional<CargoTripulante> findCargoTripulanteById = cargoTripulanteRepository.findById(catId);
        if (!findCargoTripulanteById.isPresent()) {
            throw new ResourceNotFoundException("CargoTripulante Not Found");
        }
        CargoTripulante updateCargoTripulante = findCargoTripulanteById.get();
        updateCargoTripulante.setCatNombre(cargoTripulanteUpdateByIdRequestDTO.getCatNombre());
        updateCargoTripulante.setCatFUpdate(LocalDateTime.now());
        updateCargoTripulante.setCatUUpdate("Piero");
        cargoTripulanteRepository.save(updateCargoTripulante);
    }

    public void deleteById(Long catId) {
        Optional<CargoTripulante> findCargoTripulanteById = cargoTripulanteRepository.findById(catId);
        if (!findCargoTripulanteById.isPresent()) {
            throw new ResourceNotFoundException("CargoTripulante Not Found");
        }
        cargoTripulanteRepository.deleteById(catId);
    }

}
