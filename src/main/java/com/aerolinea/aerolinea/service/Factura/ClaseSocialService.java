package com.aerolinea.aerolinea.service.Factura;

import com.aerolinea.aerolinea.dto.ClaseSocial.Request.ClaseSocialCreateRequestDTO;
import com.aerolinea.aerolinea.dto.ClaseSocial.Request.ClaseSocialUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.ClaseSocial.Response.ClaseSocialCreateResponseDTO;
import com.aerolinea.aerolinea.dto.ClaseSocial.Response.ClaseSocialGetAllResponseDTO;
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

    public ClaseSocialCreateResponseDTO create(ClaseSocialCreateRequestDTO claseSocialCreateRequestDTO) {
        ClaseSocial claseSocial = modelMapper.map(claseSocialCreateRequestDTO,ClaseSocial.class);
        claseSocial.setClsFCreate(LocalDateTime.now());
        claseSocial.setClsUCreate("Piero");
        return modelMapper.map(claseSocialRepository.save(claseSocial), ClaseSocialCreateResponseDTO.class);
    }

    public List<ClaseSocialGetAllResponseDTO> getAll() {
        List<ClaseSocial> lstClaseSocial = claseSocialRepository.findAll();
        List<ClaseSocialGetAllResponseDTO> lstClaseSocialGetAllResponseDTO = lstClaseSocial.stream()
                .map(claseSocial -> modelMapper.map(claseSocial, ClaseSocialGetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstClaseSocialGetAllResponseDTO;
    }

    public void updateById(Long clsId, ClaseSocialUpdateByIdRequestDTO claseSocialUpdateByIdRequestDTO) {
        Optional<ClaseSocial> findClaseSocialById = claseSocialRepository.findById(clsId);
        if (!findClaseSocialById.isPresent()) {
            throw new ResourceNotFoundException("ClaseSocial Not Found");
        }
        ClaseSocial updateClaseSocial = findClaseSocialById.get();
        updateClaseSocial.setClsNombre(claseSocialUpdateByIdRequestDTO.getClsNombre());
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
