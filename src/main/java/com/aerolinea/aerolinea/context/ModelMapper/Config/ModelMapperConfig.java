package com.aerolinea.aerolinea.context.ModelMapper.Config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(List<PropertyMap<?, ?>> propertyMaps) {
        ModelMapper modelMapper = new ModelMapper();
        // Registrar todos los mapeos proporcionados
        propertyMaps.forEach(modelMapper::addMappings);
        return modelMapper;
    }

}
