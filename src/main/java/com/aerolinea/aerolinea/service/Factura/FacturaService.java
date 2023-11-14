package com.aerolinea.aerolinea.service.Factura;

import com.aerolinea.aerolinea.dto.Factura.FacturaSaveDTO;
import com.aerolinea.aerolinea.dto.Factura.FacturaListDTO;
import com.aerolinea.aerolinea.exception.Exception;
import com.aerolinea.aerolinea.persistence.entity.Factura.Factura;
import com.aerolinea.aerolinea.persistence.repository.Factura.FacturaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
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

    public FacturaSaveDTO create(FacturaSaveDTO facturaDTO) {
        Factura factura = modelMapper.map(facturaDTO,Factura.class);
        factura.setFacFCreate(LocalDateTime.now());
        factura.setFacUCreate("Piero");
        factura.setFacCod(UUID.randomUUID());
        return modelMapper.map(facturaRepository.save(factura), FacturaSaveDTO.class);
    }

    public List<FacturaListDTO> getAll() {
        List<Factura> lstFactura = facturaRepository.findAll();
        List<FacturaListDTO> lstFacturaDTO = lstFactura.stream()
                .map(factura -> modelMapper.map(factura,FacturaListDTO.class))
                .collect(Collectors.toList());
        return lstFacturaDTO;
    }

    public void updateById(Long facId, FacturaSaveDTO facturaDTO) {
        Optional<Factura> findFacturaById = facturaRepository.findById(facId);
        if (!findFacturaById.isPresent()) {
            throw new Exception("Factura Not Found", HttpStatus.NOT_FOUND);
        }
        Factura updateFactura = findFacturaById.get();
        updateFactura.setFacCostoTotal(facturaDTO.getFacCostoTotal());
        updateFactura.setFacTotalImpuesto(facturaDTO.getFacTotalImpuesto());
        updateFactura.setFacFecha(facturaDTO.getFacFecha());
        updateFactura.setFacFUpdate(LocalDateTime.now());
        updateFactura.setFacUUpdate("Piero");
        facturaRepository.save(updateFactura);
        throw new Exception("Factura Update Successful", HttpStatus.OK);
    }

    public void deleteById(Long facId) {
        Optional<Factura> findFacturaById = facturaRepository.findById(facId);
        if (!findFacturaById.isPresent()) {
            throw new Exception("Factura Not Found", HttpStatus.NOT_FOUND);
        }
        facturaRepository.deleteById(facId);
        throw new Exception("Factura Removed Successful", HttpStatus.OK);
    }

}
