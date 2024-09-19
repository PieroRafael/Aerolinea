package com.aerolinea.aerolinea.service.Factura;

import com.aerolinea.aerolinea.dto.ClaseSocial.Request.CreateRequestDTO;
import com.aerolinea.aerolinea.dto.ClaseSocial.Request.UpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.ClaseSocial.Response.CreateResponseDTO;
import com.aerolinea.aerolinea.dto.ClaseSocial.Response.GetAllResponseDTO;
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

    public CreateResponseDTO create(CreateRequestDTO createRequestDTO) {
        ClaseSocial claseSocial = modelMapper.map(createRequestDTO,ClaseSocial.class);
        claseSocial.setClsFCreate(LocalDateTime.now());
        claseSocial.setClsUCreate("Piero");
        return modelMapper.map(claseSocialRepository.save(claseSocial), CreateResponseDTO.class);
    }

    public List<GetAllResponseDTO> getAll() {
        List<ClaseSocial> lstClaseSocial = claseSocialRepository.findAll();
        List<GetAllResponseDTO> lstGetAllResponseDTO = lstClaseSocial.stream()
                .map(claseSocial -> modelMapper.map(claseSocial, GetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstGetAllResponseDTO;
    }

    public void updateById(Long clsId, UpdateByIdRequestDTO updateByIdRequestDTO) {
        Optional<ClaseSocial> findClaseSocialById = claseSocialRepository.findById(clsId);
        if (!findClaseSocialById.isPresent()) {
            throw new ResourceNotFoundException("ClaseSocial Not Found");
        }
        ClaseSocial updateClaseSocial = findClaseSocialById.get();
        updateClaseSocial.setClsNombre(updateByIdRequestDTO.getClsNombre());
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
