package com.aerolinea.aerolinea.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.aerolinea.aerolinea.dto.MarcaDTO;
import com.aerolinea.aerolinea.persistence.entity.Marca;

@Component
public class MarcaMapper implements IMapper<MarcaDTO, Marca> {

    @Override
    public Marca toDomain(MarcaDTO in) {
        Marca marca = new Marca();
        marca.setMarNombre(in.getMarNombre());
        marca.setMarFCreate(LocalDateTime.now());
        marca.setMarUCreate("Piero");
        marca.setMarStatus(0);
        return marca;
    }

    @Override
    public MarcaDTO toDto(Marca out) {
        MarcaDTO marcaDTO = new MarcaDTO();
        marcaDTO.setMarNombre(out.getMarNombre());
        return marcaDTO;
    }

    @Override
    public List<Marca> toLstDomain(List<MarcaDTO> LstDto) {
        if (LstDto == null) {
            return new ArrayList<>();
        }
        return LstDto.stream().map(dto -> toDomain(dto)).collect(Collectors.toList());
    }

    @Override
    public List<MarcaDTO> toLstDto(List<Marca> LstDomain) {
        if (LstDomain == null) {
            return new ArrayList<>();
        }
        return LstDomain.stream().map(domain -> toDto(domain)).collect(Collectors.toList());
    }

}
