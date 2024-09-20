package com.aerolinea.aerolinea.service.Factura;

import com.aerolinea.aerolinea.dto.FacturaDetalle.Request.FacturaDetalleUpdateByIdRequestDTO;
import com.aerolinea.aerolinea.dto.FacturaDetalle.Response.FacturaDetalleGetAllResponseDTO;
import com.aerolinea.aerolinea.dto.FacturaDetalle.Request.FacturaDetalleCreateRequestDTO;
import com.aerolinea.aerolinea.dto.FacturaDetalle.Response.FacturaDetalleCreateResponseDTO;
import com.aerolinea.aerolinea.exception.custom.ResourceNotFoundException;
import com.aerolinea.aerolinea.persistence.entity.Avion.Asiento;
import com.aerolinea.aerolinea.persistence.entity.Factura.ClaseSocial;
import com.aerolinea.aerolinea.persistence.entity.Factura.Factura;
import com.aerolinea.aerolinea.persistence.entity.Factura.FacturaDetalle;
import com.aerolinea.aerolinea.persistence.entity.Pasajero.Pasajero;
import com.aerolinea.aerolinea.persistence.entity.Vuelo.Vuelo;
import com.aerolinea.aerolinea.persistence.repository.Factura.FacturaDetalleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FacturaDetalleService {

    private final FacturaDetalleRepository facturaDetalleRepository;

    private final ModelMapper modelMapper;

    public FacturaDetalleService(FacturaDetalleRepository facturaDetalleRepository,ModelMapper modelMapper){
        this.facturaDetalleRepository = facturaDetalleRepository;
        this.modelMapper = modelMapper;
    }

    public FacturaDetalleCreateResponseDTO create(FacturaDetalleCreateRequestDTO facturaDetalleCreateRequestDTO) {
        FacturaDetalle facturaDetalle = modelMapper.map(facturaDetalleCreateRequestDTO,FacturaDetalle.class);
        facturaDetalle.setFadUCreate("Piero");
        facturaDetalle.setFadFCreate(LocalDateTime.now());
        facturaDetalle.setFadCodeTicket(String.valueOf(UUID.randomUUID()));
        return modelMapper.map(facturaDetalleRepository.save(facturaDetalle), FacturaDetalleCreateResponseDTO.class);
    }

    public List<FacturaDetalleGetAllResponseDTO> getAll() {
        List<FacturaDetalle> lstFacturaDetalle = facturaDetalleRepository.findAll();
        List<FacturaDetalleGetAllResponseDTO> lstFacturaDetalleGetAllResponseDTO = lstFacturaDetalle.stream()
                .map(facturaDetalle -> modelMapper.map(facturaDetalle, FacturaDetalleGetAllResponseDTO.class))
                .collect(Collectors.toList());
        return lstFacturaDetalleGetAllResponseDTO;
    }

    public void updateById(Long fadId, FacturaDetalleUpdateByIdRequestDTO facturaDetalleUpdateByIdRequestDTO) {
        Optional<FacturaDetalle> findFacturaDetalleById = facturaDetalleRepository.findById(fadId);
        if (!findFacturaDetalleById.isPresent()) {
            throw new ResourceNotFoundException("FacturaDetalle Not Found");
        }
        FacturaDetalle updateFacturaDetalle = findFacturaDetalleById.get();
        updateFacturaDetalle.setFadCostoTicket(facturaDetalleUpdateByIdRequestDTO.getFadCostoTicket());
        updateFacturaDetalle.setFadDescuento(facturaDetalleUpdateByIdRequestDTO.getFadDescuento());
        updateFacturaDetalle.setVuelo(Vuelo.builder().vueId(facturaDetalleUpdateByIdRequestDTO.getVueId()).build());
        updateFacturaDetalle.setClaseSocial(ClaseSocial.builder().clsId(facturaDetalleUpdateByIdRequestDTO.getClsId()).build());
        updateFacturaDetalle.setAsiento(Asiento.builder().astId(facturaDetalleUpdateByIdRequestDTO.getAstId()).build());
        updateFacturaDetalle.setPasajero(Pasajero.builder().pasId(facturaDetalleUpdateByIdRequestDTO.getPasId()).build());
        updateFacturaDetalle.setFactura(Factura.builder().facId(facturaDetalleUpdateByIdRequestDTO.getFacId()).build());
        updateFacturaDetalle.setFadFUpdate(LocalDateTime.now());
        updateFacturaDetalle.setFadUUpdate("Piero");
        facturaDetalleRepository.save(updateFacturaDetalle);
    }

    public void deleteById(Long fadId) {
        Optional<FacturaDetalle> findFacturaDetalleById = facturaDetalleRepository.findById(fadId);
        if (!findFacturaDetalleById.isPresent()) {
            throw new ResourceNotFoundException("FacturaDetalle Not Found");
        }
        facturaDetalleRepository.deleteById(fadId);
    }

}
