package com.aerolinea.aerolinea.service.Vuelo;

import com.aerolinea.aerolinea.dto.Vuelo.Request.VueloUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.Vuelo.Response.VueloCreateResponseDTO;
import com.aerolinea.aerolinea.dto.Vuelo.Response.VueloGetAllResponseDTO;
import com.aerolinea.aerolinea.dto.Vuelo.Request.VueloCreateRequestDTO;
import com.aerolinea.aerolinea.exception.custom.ResourceNotFoundException;
import com.aerolinea.aerolinea.persistence.entity.Avion.Avion;
import com.aerolinea.aerolinea.persistence.entity.Ruta.Ruta;
import com.aerolinea.aerolinea.persistence.entity.Vuelo.Vuelo;
import com.aerolinea.aerolinea.persistence.repository.Vuelo.VueloRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VueloService {

    private final VueloRepository vueloRepository;

    private final ModelMapper modelMapper;

    public VueloService(VueloRepository vueloRepository,ModelMapper modelMapper){
        this.vueloRepository = vueloRepository;
        this.modelMapper = modelMapper;
    }

    public VueloCreateResponseDTO create(VueloCreateRequestDTO vueloCreateRequestDTO) {
        Vuelo vuelo = modelMapper.map(vueloCreateRequestDTO, Vuelo.class);
        vuelo.setVueFCreate(LocalDateTime.now());
        vuelo.setVueUCreate("Piero");
        vuelo.setVueCod(String.valueOf(UUID.randomUUID()));
        return modelMapper.map(vueloRepository.save(vuelo), VueloCreateResponseDTO.class);
    }

    public List<VueloGetAllResponseDTO> getAll() {
        List<Vuelo> lstVuelo = vueloRepository.findAll();
        List<VueloGetAllResponseDTO> lstVueloGetAllResponseDTO = lstVuelo.stream()
                .map(vuelo -> modelMapper.map(vuelo, VueloGetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstVueloGetAllResponseDTO;
    }

    public void updateById(Long vueId, VueloUpdateByIdRequestDTO vueloUpdateByIdRequestDTO) {
        Optional<Vuelo> findVueloById = vueloRepository.findById(vueId);
        if (!findVueloById.isPresent()) {
            throw new ResourceNotFoundException("Vuelo Not Found");
        }
        Vuelo updateVuelo = findVueloById.get();
        updateVuelo.setVueFHPartida(vueloUpdateByIdRequestDTO.getVueFHPartida());
        updateVuelo.setVueFHLlegada(vueloUpdateByIdRequestDTO.getVueFHLlegada());
        updateVuelo.setRuta(Ruta.builder().rtaId(vueloUpdateByIdRequestDTO.getRtaId()).build());
        updateVuelo.setAvion(Avion.builder().aviId(vueloUpdateByIdRequestDTO.getAviId()).build());
        updateVuelo.setVueFUpdate(LocalDateTime.now());
        updateVuelo.setVueUUpdate("Piero");
        vueloRepository.save(updateVuelo);
    }

    public void deleteById(Long vueId) {
        Optional<Vuelo> findVueloById = vueloRepository.findById(vueId);
        if (!findVueloById.isPresent()) {
            throw new ResourceNotFoundException("Vuelo Not Found");
        }
        vueloRepository.deleteById(vueId);
    }

    public void deactivateByVueId(Long vueId) {
        Optional<Vuelo> findVueloById = vueloRepository.findById(vueId);
        if (!findVueloById.isPresent()) {
            throw new ResourceNotFoundException("Vuelo Not Found");
        }
        vueloRepository.deactivateByVueId(vueId);
    }

    public void activateByVueId(Long vueId) {
        Optional<Vuelo> findVueloById = vueloRepository.findById(vueId);
        if (!findVueloById.isPresent()) {
            throw new ResourceNotFoundException("Vuelo Not Found");
        }
        vueloRepository.activateByVueId(vueId);
    }

    public List<VueloGetAllResponseDTO> getAllDeactivate() {
        List<Vuelo> lstVuelo = vueloRepository.getAllDeactivate();
        List<VueloGetAllResponseDTO> lstVueloGetAllResponseDTO = lstVuelo.stream()
                .map(vuelo -> modelMapper.map(vuelo, VueloGetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstVueloGetAllResponseDTO;
    }

    public List<VueloGetAllResponseDTO> getAllActivated() {
        List<Vuelo> lstVuelo = vueloRepository.getAllActivated();
        List<VueloGetAllResponseDTO> lstVueloGetAllResponseDTO = lstVuelo.stream()
                .map(vuelo -> modelMapper.map(vuelo, VueloGetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstVueloGetAllResponseDTO;
    }

}
