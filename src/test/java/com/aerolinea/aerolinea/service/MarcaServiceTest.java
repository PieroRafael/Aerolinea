package com.aerolinea.aerolinea.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.aerolinea.aerolinea.dto.MarcaDTO;
import com.aerolinea.aerolinea.mapper.MarcaMapper;
import com.aerolinea.aerolinea.persistence.entity.Marca;
import com.aerolinea.aerolinea.persistence.repository.MarcaRepository;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class MarcaServiceTest {

    @InjectMocks
    private MarcaService marcaService;

    @Autowired
    private MarcaRepository marcaRepository;

    private MarcaMapper marcaMapper;

    MarcaDTO marca;

    @BeforeEach
    void setup() {
        marcaMapper = new MarcaMapper();
        marcaService = new MarcaService(marcaRepository, marcaMapper);
        marca = MarcaDTO.builder().marNombre("Phantom").build();
    }

    @Test
    void shouldReturnDTOInSaveMarca() {
        Marca marcaSave = marcaMapper.toDomain(marca);
        when(marcaMapper.toDto(marcaRepository.save(marcaSave))).thenReturn(marca);
        assertNotNull(marca);
    }

}
