package com.aerolinea.aerolinea.service.Tripulacion;

import com.aerolinea.aerolinea.dto.CargoTripulante.CargoTripulanteDTO;
import com.aerolinea.aerolinea.exception.Exception;
import com.aerolinea.aerolinea.persistence.entity.Tripulacion.CargoTripulante;
import com.aerolinea.aerolinea.persistence.repository.Tripulacion.CargoTripulanteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
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

    public CargoTripulanteDTO create(CargoTripulanteDTO cargoTripulanteDTO) {
        CargoTripulante cargoTripulante = modelMapper.map(cargoTripulanteDTO, CargoTripulante.class);
        cargoTripulante.setCatFCreate(LocalDateTime.now());
        cargoTripulante.setCatUCreate("Piero");
        return modelMapper.map(cargoTripulanteRepository.save(cargoTripulante),CargoTripulanteDTO.class);
    }

    public List<CargoTripulanteDTO> getAll() {
        List<CargoTripulante> lstCargoTripulante = cargoTripulanteRepository.findAll();
        List<CargoTripulanteDTO> lstCargoTripulanteDTO = lstCargoTripulante.stream()
                .map(cargoTripulante -> modelMapper.map(cargoTripulante,CargoTripulanteDTO.class))
                .collect(Collectors.toList());
        return lstCargoTripulanteDTO;
    }

    public void updateById(Long catId, CargoTripulanteDTO cargoTripulanteDTO) {
        Optional<CargoTripulante> findCargoTripulanteById = cargoTripulanteRepository.findById(catId);
        if (!findCargoTripulanteById.isPresent()) {
            throw new Exception("CargoTripulante Not Found", HttpStatus.NOT_FOUND);
        }
        CargoTripulante updateCargoTripulante = findCargoTripulanteById.get();
        updateCargoTripulante.setCatNombre(cargoTripulanteDTO.getCatNombre());
        updateCargoTripulante.setCatFUpdate(LocalDateTime.now());
        updateCargoTripulante.setCatUUpdate("Piero");
        cargoTripulanteRepository.save(updateCargoTripulante);
        throw new Exception("CargoTripulante Update Successful", HttpStatus.OK);
    }

    public void deleteById(Long catId) {
        Optional<CargoTripulante> findCargoTripulanteById = cargoTripulanteRepository.findById(catId);
        if (!findCargoTripulanteById.isPresent()) {
            throw new Exception("CargoTripulante Not Found", HttpStatus.NOT_FOUND);
        }
        cargoTripulanteRepository.deleteById(catId);
        throw new Exception("CargoTripulante Removed Successful", HttpStatus.OK);
    }

}
