package com.aerolinea.aerolinea.service.Factura;

import com.aerolinea.aerolinea.dto.ClaseSocial.ClaseSocialDTO;
import com.aerolinea.aerolinea.exception.custom.ResourceNotFoundException;
import com.aerolinea.aerolinea.persistence.entity.Factura.ClaseSocial;
import com.aerolinea.aerolinea.persistence.repository.Factura.ClaseSocialRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClaseSocialService {

    private final ClaseSocialRepository claseSocialRepository;

    private final ModelMapper modelMapper;

    public ClaseSocialService(ClaseSocialRepository claseSocialRepository,ModelMapper modelMapper){
        this.claseSocialRepository = claseSocialRepository;
        this.modelMapper = modelMapper;
    }

    public ClaseSocialDTO create(ClaseSocialDTO claseSocialDTO) {
        ClaseSocial claseSocial = modelMapper.map(claseSocialDTO,ClaseSocial.class);
        claseSocial.setClsFCreate(LocalDateTime.now());
        claseSocial.setClsUCreate("Piero");
        return modelMapper.map(claseSocialRepository.save(claseSocial),ClaseSocialDTO.class);
    }

    public List<ClaseSocialDTO> getAll() {
        List<ClaseSocial> lstClaseSocial = claseSocialRepository.findAll();
        List<ClaseSocialDTO> lstClaseSocialDTO = lstClaseSocial.stream()
                .map(claseSocial -> modelMapper.map(claseSocial,ClaseSocialDTO.class))
                .collect(Collectors.toList());
        return lstClaseSocialDTO;
    }

    public void updateById(Long clsId, ClaseSocialDTO claseSocialDTO) {
        Optional<ClaseSocial> findClaseSocialById = claseSocialRepository.findById(clsId);
        if (!findClaseSocialById.isPresent()) {
            throw new ResourceNotFoundException("ClaseSocial Not Found");
        }
        ClaseSocial updateClaseSocial = findClaseSocialById.get();
        updateClaseSocial.setClsNombre(claseSocialDTO.getClsNombre());
        updateClaseSocial.setClsFUpdate(LocalDateTime.now());
        updateClaseSocial.setClsUUpdate("Piero");
        claseSocialRepository.save(updateClaseSocial);
    }

    public void deleteById(Long clsId) {
        Optional<ClaseSocial> findClaseSocialById = claseSocialRepository.findById(clsId);
        if (!findClaseSocialById.isPresent()) {
            throw new ResourceNotFoundException("ClaseSocial Not Found");
        }
        claseSocialRepository.deleteById(clsId);
    }

}
