package com.aerolinea.aerolinea.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.aerolinea.aerolinea.persistence.entity.Marca;
import com.aerolinea.aerolinea.persistence.repository.MarcaRepository;

@DataJpaTest
public class MarcaRepositoryTest {

    @Autowired
    private MarcaRepository marcaRepository;

    private Marca marca;

    @BeforeEach
    void setup() {
        marca = Marca.builder().marNombre("Phantom").marStatus(0).build();
    }

    @DisplayName("Test para crear marca")
    @Test
    void testCreateMarca() {
        // ? Principio de BDD (Metologia)
        // Given (Dado o condición previa o configuración)
        Marca marca1 = Marca.builder().marNombre("Phantom").build();
        // When (Acción o el comportamiento que vamos a probar)
        Marca marcaCreate = marcaRepository.save(marca1);
        // Then (Verificar la salida)
        assertThat(marcaCreate).isNotNull();
        assertThat(marcaCreate.getMarId()).isGreaterThan(0);
    }

    @DisplayName("Test para listar marcas")
    @Test
    void testListarMarca() {
        // Given
        marcaRepository.save(marca);
        // When
        List<Marca> listMarca = marcaRepository.findAll();
        // Then
        assertThat(listMarca).isNotNull();
        assertThat(listMarca).size().isEqualTo(2);
    }

}
