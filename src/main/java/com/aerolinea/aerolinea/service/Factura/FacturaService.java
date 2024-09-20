package com.aerolinea.aerolinea.service.Factura;

import com.aerolinea.aerolinea.dto.Factura.Request.FacturaCreateRequestDTO;
import com.aerolinea.aerolinea.dto.Factura.Request.FacturaUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.Factura.Response.FacturaGetAllResponseDTO;
import com.aerolinea.aerolinea.dto.Factura.Response.FacturaCreateResponseDTO;
import com.aerolinea.aerolinea.exception.custom.ResourceNotFoundException;
import com.aerolinea.aerolinea.persistence.entity.Factura.Factura;
import com.aerolinea.aerolinea.persistence.repository.Factura.FacturaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FacturaService {

    private final FacturaRepository facturaRepository;

    private final ModelMapper modelMapper;

    public FacturaService(FacturaRepository facturaRepository,ModelMapper modelMapper) {
        this.facturaRepository = facturaRepository;
        this.modelMapper = modelMapper;
    }

    public FacturaCreateResponseDTO create(FacturaCreateRequestDTO facturaCreateRequestDTO) {
        Factura factura = modelMapper.map(facturaCreateRequestDTO,Factura.class);
        factura.setFacFCreate(LocalDateTime.now());
        factura.setFacUCreate("Piero");
        factura.setFacCod(String.valueOf(UUID.randomUUID()));
        return modelMapper.map(facturaRepository.save(factura), FacturaCreateResponseDTO.class);
    }

    public List<FacturaGetAllResponseDTO> getAll() {
        List<Factura> lstFactura = facturaRepository.findAll();
        List<FacturaGetAllResponseDTO> lstFacturaDTO = lstFactura.stream()
                .map(factura -> modelMapper.map(factura, FacturaGetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstFacturaDTO;
    }

    public void updateById(Long facId, FacturaUpdateByIdRequestDTO facturaUpdateByIdRequestDTO) {
        Optional<Factura> findFacturaById = facturaRepository.findById(facId);
        if (!findFacturaById.isPresent()) {
            throw new ResourceNotFoundException("Factura Not Found");
        }
        Factura updateFactura = findFacturaById.get();
        updateFactura.setFacCostoTotal(facturaUpdateByIdRequestDTO.getFacCostoTotal());
        updateFactura.setFacTotalImpuesto(facturaUpdateByIdRequestDTO.getFacTotalImpuesto());
        updateFactura.setFacFecha(facturaUpdateByIdRequestDTO.getFacFecha());
        updateFactura.setFacFUpdate(LocalDateTime.now());
        updateFactura.setFacUUpdate("Piero");
        facturaRepository.save(updateFactura);
    }

    public void deleteById(Long facId) {
        Optional<Factura> findFacturaById = facturaRepository.findById(facId);
        if (!findFacturaById.isPresent()) {
            throw new ResourceNotFoundException("Factura Not Found");
        }
        facturaRepository.deleteById(facId);
    }

}
