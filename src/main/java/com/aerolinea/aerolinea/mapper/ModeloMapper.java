package com.aerolinea.aerolinea.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.aerolinea.aerolinea.dto.ModeloDTO;
import com.aerolinea.aerolinea.persistence.entity.Modelo;

@Component
public class ModeloMapper implements IMapper<ModeloDTO, Modelo> {

    @Override
    public Modelo toDomain(ModeloDTO in) {
        Modelo modelo = new Modelo();
        modelo.setModNombre(in.getModNombre());
        modelo.setModFCreate(LocalDateTime.now());
        modelo.setModUCreate("Piero");
        modelo.setModStatus(0);
        return modelo;
    }

    @Override
    public ModeloDTO toDto(Modelo out) {
        ModeloDTO modeloDTO = new ModeloDTO();
        modeloDTO.setModNombre(out.getModNombre());
        return modeloDTO;
    }

    @Override
    public List<Modelo> toLstDomain(List<ModeloDTO> LstDto) {
        if (LstDto == null) {
            return new ArrayList<>();
        }
        return LstDto.stream().map(dto -> toDomain(dto)).collect(Collectors.toList());
    }

    @Override
    public List<ModeloDTO> toLstDto(List<Modelo> LstDomain) {
        if (LstDomain == null) {
            return new ArrayList<>();
        }
        return LstDomain.stream().map(domain -> toDto(domain)).collect(Collectors.toList());
    }

}
