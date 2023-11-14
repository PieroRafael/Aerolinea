package com.aerolinea.aerolinea.service.Factura;

import com.aerolinea.aerolinea.dto.FacturaDetalle.FacturaDetalleListDTO;
import com.aerolinea.aerolinea.dto.FacturaDetalle.FacturaDetalleSaveDTO;
import com.aerolinea.aerolinea.exception.Exception;
import com.aerolinea.aerolinea.persistence.entity.Avion.Asiento;
import com.aerolinea.aerolinea.persistence.entity.Factura.ClaseSocial;
import com.aerolinea.aerolinea.persistence.entity.Factura.Factura;
import com.aerolinea.aerolinea.persistence.entity.Factura.FacturaDetalle;
import com.aerolinea.aerolinea.persistence.entity.Pasajero.Pasajero;
import com.aerolinea.aerolinea.persistence.entity.Vuelo.Vuelo;
import com.aerolinea.aerolinea.persistence.repository.Factura.FacturaDetalleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
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

    public FacturaDetalleSaveDTO create(FacturaDetalleSaveDTO facturaDetalleSaveDTO) {
        FacturaDetalle facturaDetalle = modelMapper.map(facturaDetalleSaveDTO,FacturaDetalle.class);
        facturaDetalle.setFadUCreate("Piero");
        facturaDetalle.setFadFCreate(LocalDateTime.now());
        facturaDetalle.setFadCodeTicket(UUID.randomUUID());
        return modelMapper.map(facturaDetalleRepository.save(facturaDetalle),FacturaDetalleSaveDTO.class);
    }

    public List<FacturaDetalleListDTO> getAll() {
        List<FacturaDetalle> lstFacturaDetalle = facturaDetalleRepository.findAll();
        List<FacturaDetalleListDTO> lstFacturaDetalleListDTO = lstFacturaDetalle.stream()
                .map(facturaDetalle -> modelMapper.map(facturaDetalle,FacturaDetalleListDTO.class))
                .collect(Collectors.toList());
        return lstFacturaDetalleListDTO;
    }

    public void updateById(Long fadId, FacturaDetalleSaveDTO facturaDetalleSaveDTO) {
        Optional<FacturaDetalle> findFacturaDetalleById = facturaDetalleRepository.findById(fadId);
        if (!findFacturaDetalleById.isPresent()) {
            throw new Exception("FacturaDetalle Not Found", HttpStatus.NOT_FOUND);
        }
        FacturaDetalle updateFacturaDetalle = findFacturaDetalleById.get();
        updateFacturaDetalle.setFadCostoTicket(facturaDetalleSaveDTO.getFadCostoTicket());
        updateFacturaDetalle.setFadDescuento(facturaDetalleSaveDTO.getFadDescuento());
        updateFacturaDetalle.setVuelo(Vuelo.builder().vueId(facturaDetalleSaveDTO.getVueId()).build());
        updateFacturaDetalle.setClaseSocial(ClaseSocial.builder().clsId(facturaDetalleSaveDTO.getClsId()).build());
        updateFacturaDetalle.setAsiento(Asiento.builder().astId(facturaDetalleSaveDTO.getAstId()).build());
        updateFacturaDetalle.setPasajero(Pasajero.builder().pasId(facturaDetalleSaveDTO.getPasId()).build());
        updateFacturaDetalle.setFactura(Factura.builder().facId(facturaDetalleSaveDTO.getFacId()).build());
        updateFacturaDetalle.setFadFUpdate(LocalDateTime.now());
        updateFacturaDetalle.setFadUUpdate("Piero");
        facturaDetalleRepository.save(updateFacturaDetalle);
        throw new Exception("FacturaDetalle Update Successful", HttpStatus.OK);
    }

    public void deleteById(Long fadId) {
        Optional<FacturaDetalle> findFacturaDetalleById = facturaDetalleRepository.findById(fadId);
        if (!findFacturaDetalleById.isPresent()) {
            throw new Exception("FacturaDetalle Not Found", HttpStatus.NOT_FOUND);
        }
        facturaDetalleRepository.deleteById(fadId);
        throw new Exception("FacturaDetalle Removed Successful", HttpStatus.OK);
    }

}
