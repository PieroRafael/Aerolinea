package com.aerolinea.aerolinea.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.aerolinea.aerolinea.dto.AvionListDTO;
import com.aerolinea.aerolinea.dto.AvionSaveDTO;
import com.aerolinea.aerolinea.persistence.entity.Avion;
import com.aerolinea.aerolinea.persistence.entity.Marca;
import com.aerolinea.aerolinea.persistence.entity.Modelo;

@Component
public class AvionMapper implements IAvionMapper<AvionSaveDTO, Avion, AvionListDTO> {

    @Override
    public Avion toDomain(AvionSaveDTO in) {
        Avion avion = new Avion();
        avion.setAviRegistro(in.getAviRegistro());
        avion.setAviCantidadAsientos(in.getAviCantidadAsientos());
        avion.setMarca(Marca.builder().marId(in.getMarId()).build());
        avion.setModelo(Modelo.builder().modId(in.getModId()).build());
        avion.setAviFCreate(LocalDateTime.now());
        avion.setAviUCreate("Piero");
        avion.setAviStatus(0);
        return avion;
    }

    @Override
    public AvionSaveDTO toDto(Avion out) {
        AvionSaveDTO avionSaveDTO = new AvionSaveDTO();
        avionSaveDTO.setAviRegistro(out.getAviRegistro());
        avionSaveDTO.setAviCantidadAsientos(out.getAviCantidadAsientos());
        avionSaveDTO.setMarId(out.getMarca().getMarId());
        avionSaveDTO.setModId(out.getModelo().getModId());
        return avionSaveDTO;
    }

    @Override
    public AvionListDTO toDtoAvion(Avion in) {
        AvionListDTO avionListDTO = new AvionListDTO();
        avionListDTO.setAviRegistro(in.getAviRegistro());
        avionListDTO.setAviCantidadAsientos(in.getAviCantidadAsientos());
        avionListDTO.setMarNombre(in.getMarca().getMarNombre());
        avionListDTO.setModNombre(in.getModelo().getModNombre());
        return avionListDTO;
    }

    @Override
    public List<Avion> toLstDomain(List<AvionSaveDTO> LstDto) {
        if (LstDto == null) {
            return new ArrayList<>();
        }
        return LstDto.stream().map(dto -> toDomain(dto)).collect(Collectors.toList());
    }

    @Override
    public List<AvionSaveDTO> toLstDto(List<Avion> LstDomain) {
        if (LstDomain == null) {
            return new ArrayList<>();
        }
        return LstDomain.stream().map(domain -> toDto(domain)).collect(Collectors.toList());
    }

    @Override
    public List<AvionListDTO> toLstDtoAvion(List<Avion> LstDto) {
        if (LstDto == null) {
            return new ArrayList<>();
        }
        return LstDto.stream().map(domain -> toDtoAvion(domain)).collect(Collectors.toList());
    }

}
