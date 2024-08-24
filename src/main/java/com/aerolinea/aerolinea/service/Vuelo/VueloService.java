package com.aerolinea.aerolinea.service.Vuelo;

import com.aerolinea.aerolinea.dto.Vuelo.VueloListDTO;
import com.aerolinea.aerolinea.dto.Vuelo.VueloSaveDTO;
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

    public VueloSaveDTO create(VueloSaveDTO vueloSaveDTO) {
        Vuelo vuelo = modelMapper.map(vueloSaveDTO, Vuelo.class);
        vuelo.setVueFCreate(LocalDateTime.now());
        vuelo.setVueUCreate("Piero");
        vuelo.setVueCod(String.valueOf(UUID.randomUUID()));
        return modelMapper.map(vueloRepository.save(vuelo),VueloSaveDTO.class);
    }

    public List<VueloListDTO> getAll() {
        List<Vuelo> lstVuelo = vueloRepository.findAll();
        List<VueloListDTO> lstVueloDTO = lstVuelo.stream()
                .map(vuelo -> modelMapper.map(vuelo,VueloListDTO.class))
                .collect(Collectors.toList());
        return lstVueloDTO;
    }

    public void updateById(Long vueId, VueloSaveDTO vueloSaveDTO) {
        Optional<Vuelo> findVueloById = vueloRepository.findById(vueId);
        if (!findVueloById.isPresent()) {
            throw new ResourceNotFoundException("Vuelo Not Found");
        }
        Vuelo updateVuelo = findVueloById.get();
        updateVuelo.setVueFHPartida(vueloSaveDTO.getVueFHPartida());
        updateVuelo.setVueFHLlegada(vueloSaveDTO.getVueFHLlegada());
        updateVuelo.setRuta(Ruta.builder().rtaId(vueloSaveDTO.getRtaId()).build());
        updateVuelo.setAvion(Avion.builder().aviId(vueloSaveDTO.getAviId()).build());
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

    public List<VueloListDTO> getAllDeactivate() {
        List<Vuelo> lstVuelo = vueloRepository.getAllDeactivate();
        List<VueloListDTO> lstVueloDTO = lstVuelo.stream()
                .map(vuelo -> modelMapper.map(vuelo,VueloListDTO.class))
                .collect(Collectors.toList());
        return lstVueloDTO;
    }

    public List<VueloListDTO> getAllActivated() {
        List<Vuelo> lstVuelo = vueloRepository.getAllActivated();
        List<VueloListDTO> lstVueloDTO = lstVuelo.stream()
                .map(vuelo -> modelMapper.map(vuelo,VueloListDTO.class))
                .collect(Collectors.toList());
        return lstVueloDTO;
    }

}
