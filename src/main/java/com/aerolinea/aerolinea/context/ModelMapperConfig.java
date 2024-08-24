package com.aerolinea.aerolinea.context;

import com.aerolinea.aerolinea.dto.Asiento.AsientoListDTO;
import com.aerolinea.aerolinea.dto.Asiento.AsientoSaveDTO;
import com.aerolinea.aerolinea.dto.Avion.AvionListDTO;
import com.aerolinea.aerolinea.dto.Avion.AvionSaveDTO;
import com.aerolinea.aerolinea.dto.FacturaDetalle.FacturaDetalleListDTO;
import com.aerolinea.aerolinea.dto.FacturaDetalle.FacturaDetalleSaveDTO;
import com.aerolinea.aerolinea.dto.PuntoRuta.PuntoRutaListDTO;
import com.aerolinea.aerolinea.dto.PuntoRuta.PuntoRutaSaveDTO;
import com.aerolinea.aerolinea.dto.Tripulacion.TripulacionListDTO;
import com.aerolinea.aerolinea.dto.Tripulacion.TripulacionSaveDTO;
import com.aerolinea.aerolinea.dto.TripulacionVuelo.TripulacionVueloListDTO;
import com.aerolinea.aerolinea.dto.TripulacionVuelo.TripulacionVueloSaveDTO;
import com.aerolinea.aerolinea.dto.Vuelo.VueloListDTO;
import com.aerolinea.aerolinea.dto.Vuelo.VueloSaveDTO;
import com.aerolinea.aerolinea.persistence.entity.Avion.Asiento;
import com.aerolinea.aerolinea.persistence.entity.Avion.Avion;
import com.aerolinea.aerolinea.persistence.entity.Factura.FacturaDetalle;
import com.aerolinea.aerolinea.persistence.entity.Ruta.PuntoRuta;
import com.aerolinea.aerolinea.persistence.entity.Tripulacion.Tripulacion;
import com.aerolinea.aerolinea.persistence.entity.Tripulacion.TripulacionVuelo;
import com.aerolinea.aerolinea.persistence.entity.Vuelo.Vuelo;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){

        ModelMapper modelMapper = new ModelMapper();

        // Configuración personalizada AvionSaveDTO -> Avion
        modelMapper.addMappings(new PropertyMap<AvionSaveDTO, Avion>() {
            @Override
            protected void configure() {
                map().getMarca().setMarId(source.getMarId());
                map().getModelo().setModId(source.getModId());
            }
        });

        // Configuración personalizada Avion -> AvionSaveDTO
        modelMapper.addMappings(new PropertyMap<Avion, AvionSaveDTO>() {
            @Override
            protected void configure() {
                map().setMarId(source.getMarca().getMarId());
                map().setModId(source.getModelo().getModId());
            }
        });

        // Configuración personalizada Avion -> AvionListDTO
        modelMapper.addMappings(new PropertyMap<Avion, AvionListDTO>() {
            @Override
            protected void configure() {
                map().setMarNombre(source.getMarca().getMarNombre());
                map().setModNombre(source.getModelo().getModNombre());
            }
        });

        // Configuración personalizada AvionListDTO -> Avion
        modelMapper.addMappings(new PropertyMap<AvionListDTO, Avion>() {
            @Override
            protected void configure() {
                map().getMarca().setMarNombre(source.getMarNombre());
                map().getModelo().setModNombre(source.getModNombre());
            }
        });

        // Configuración personalizada AsientoSaveDTO -> Asiento
        modelMapper.addMappings(new PropertyMap<AsientoSaveDTO, Asiento>() {
            @Override
            protected void configure() {
                map().getTipoAsiento().setTpaId(source.getTpaId());
                map().getAvion().setAviId(source.getAviId());
            }
        });

        // Configuración personalizada Asiento -> AsientoSaveDTO
        modelMapper.addMappings(new PropertyMap<Asiento, AsientoSaveDTO>() {
            @Override
            protected void configure() {
                map().setAviId(source.getAvion().getAviId());
                map().setTpaId(source.getTipoAsiento().getTpaId());
            }
        });

        // Configuración personalizada Asiento -> AsientoListDTO
        modelMapper.addMappings(new PropertyMap<Asiento, AsientoListDTO>() {
            @Override
            protected void configure() {
                map().setTpaNombre(source.getTipoAsiento().getTpaNombre());
                map().setAviRegistro(source.getAvion().getAviRegistro());
            }
        });

        // Configuración personalizada AsientoListDTO -> Asiento
        modelMapper.addMappings(new PropertyMap<AsientoListDTO, Asiento>() {
            @Override
            protected void configure() {
                map().getTipoAsiento().setTpaNombre(source.getTpaNombre());
                map().getAvion().setAviRegistro(source.getAviRegistro());
            }
        });

        // Configuración personalizada VueloSaveDTO -> Vuelo
        modelMapper.addMappings(new PropertyMap<VueloSaveDTO, Vuelo>() {
            @Override
            protected void configure() {
                map().getAvion().setAviId(source.getAviId());
                map().getRuta().setRtaId(source.getRtaId());
            }
        });

        // Configuración personalizada Vuelo -> VueloSaveDTO
        modelMapper.addMappings(new PropertyMap<Vuelo, VueloSaveDTO>() {
            @Override
            protected void configure() {
                map().setAviId(source.getAvion().getAviId());
                map().setRtaId(source.getRuta().getRtaId());
            }
        });

        // Configuración personalizada Vuelo -> VueloListDTO
        modelMapper.addMappings(new PropertyMap<Vuelo, VueloListDTO>() {
            @Override
            protected void configure() {
                map().setAviRegistro(source.getAvion().getAviRegistro());
                map().setRtaNombre(source.getRuta().getRtaNombre());
            }
        });

        // Configuración personalizada VueloListDTO -> Vuelo
        modelMapper.addMappings(new PropertyMap<VueloListDTO, Vuelo>() {
            @Override
            protected void configure() {
                map().getAvion().setAviRegistro(source.getAviRegistro());
                map().getRuta().setRtaNombre(source.getRtaNombre());
            }
        });

        // Configuración personalizada FacturaDetalleSaveDTO -> FacturaDetalle
        modelMapper.addMappings(new PropertyMap<FacturaDetalleSaveDTO, FacturaDetalle>() {
            @Override
            protected void configure() {
                map().getAsiento().setAstId(source.getAstId());
                map().getClaseSocial().setClsId(source.getClsId());
                map().getVuelo().setVueId(source.getVueId());
                map().getPasajero().setPasId(source.getPasId());
                map().getFactura().setFacId(source.getFacId());
            }
        });

        // Configuración personalizada FacturaDetalle -> FacturaDetalleSaveDTO
        modelMapper.addMappings(new PropertyMap<FacturaDetalle, FacturaDetalleSaveDTO>() {
            @Override
            protected void configure() {
                map().setAstId(source.getAsiento().getAstId());
                map().setClsId(source.getClaseSocial().getClsId());
                map().setVueId(source.getVuelo().getVueId());
                map().setPasId(source.getPasajero().getPasId());
                map().setFacId(source.getFactura().getFacId());
            }
        });

        // Configuración personalizada FacturaDetalle -> FacturaDetalleListDTO
        modelMapper.addMappings(new PropertyMap<FacturaDetalle, FacturaDetalleListDTO>() {
            @Override
            protected void configure() {
                map().setAstNombre(source.getAsiento().getAstNombre());
                map().setClsNombre(source.getClaseSocial().getClsNombre());
                map().setPasNombre(source.getPasajero().getPasNombre());
                map().setPasApellido(source.getPasajero().getPasApellido());
                map().setVueCod(source.getVuelo().getVueCod());
                map().setFacCod(source.getFactura().getFacCod());
            }
        });

        // Configuración personalizada FacturaDetalleListDTO -> FacturaDetalle
        modelMapper.addMappings(new PropertyMap<FacturaDetalleListDTO, FacturaDetalle>() {
            @Override
            protected void configure() {
                map().getAsiento().setAstNombre(source.getAstNombre());
                map().getClaseSocial().setClsNombre(source.getClsNombre());
                map().getPasajero().setPasNombre(source.getPasNombre());
                map().getPasajero().setPasApellido(source.getPasApellido());
                map().getVuelo().setVueCod(source.getVueCod());
                map().getFactura().setFacCod(source.getFacCod());
            }
        });

        // Configuración personalizada TripulacionSaveDTO -> Tripulacion
        modelMapper.addMappings(new PropertyMap<TripulacionSaveDTO, Tripulacion>() {
            @Override
            protected void configure() {
                map().getCargoTripulante().setCatId(source.getCatId());
            }
        });

        // Configuración personalizada Tripulacion -> TripulacionSaveDTO
        modelMapper.addMappings(new PropertyMap<Tripulacion, TripulacionSaveDTO>() {
            @Override
            protected void configure() {
                map().setCatId(source.getCargoTripulante().getCatId());
            }
        });

        // Configuración personalizada Tripulacion -> TripulacionListDTO
        modelMapper.addMappings(new PropertyMap<Tripulacion, TripulacionListDTO>() {
            @Override
            protected void configure() {
                map().setCatNombre(source.getCargoTripulante().getCatNombre());
            }
        });

        // Configuración personalizada TripulacionListDTO -> Tripulacion
        modelMapper.addMappings(new PropertyMap<TripulacionListDTO, Tripulacion>() {
            @Override
            protected void configure() {
                map().getCargoTripulante().setCatNombre(source.getCatNombre());
            }
        });

        // Configuración personalizada TripulacionVueloSaveDTO -> TripulacionVuelo
        modelMapper.addMappings(new PropertyMap<TripulacionVueloSaveDTO, TripulacionVuelo>() {
            @Override
            protected void configure() {
                map().getTripulacion().setTriId(source.getTriId());
                map().getVuelo().setVueId(source.getVueId());

            }
        });

        // Configuración personalizada TripulacionVuelo -> TripulacionVueloSaveDTO
        modelMapper.addMappings(new PropertyMap<TripulacionVuelo, TripulacionVueloSaveDTO>() {
            @Override
            protected void configure() {
                map().setVueId(source.getVuelo().getVueId());
                map().setTriId(source.getTripulacion().getTriId());
            }
        });

        // Configuración personalizada TripulacionVuelo -> TripulacionVueloListDTO
        modelMapper.addMappings(new PropertyMap<TripulacionVuelo, TripulacionVueloListDTO>() {
            @Override
            protected void configure() {
                map().setTriNombre(source.getTripulacion().getTriNombre());
                map().setTriApellido(source.getTripulacion().getTriApellido());
                map().setTriCodigo(source.getTripulacion().getTriCodigo());
                map().setVueCod(source.getVuelo().getVueCod());
                map().setVueFHPartida(source.getVuelo().getVueFHPartida());
                map().setVueFHLlegada(source.getVuelo().getVueFHLlegada());
                map().setCatNombre(source.getTripulacion().getCargoTripulante().getCatNombre());
                map().setAviRegistro(source.getVuelo().getAvion().getAviRegistro());
                map().setRtaNombre(source.getVuelo().getRuta().getRtaNombre());
            }
        });

        // Configuración personalizada TripulacionVueloListDTO -> TripulacionVuelo
        modelMapper.addMappings(new PropertyMap<TripulacionVueloListDTO, TripulacionVuelo>() {
            @Override
            protected void configure() {
                map().getTripulacion().setTriNombre(source.getTriNombre());
                map().getTripulacion().setTriApellido(source.getTriApellido());
                map().getTripulacion().setTriCodigo(source.getTriCodigo());
                map().getVuelo().setVueCod(source.getVueCod());
                map().getVuelo().setVueFHPartida(source.getVueFHPartida());
                map().getVuelo().setVueFHLlegada(source.getVueFHLlegada());
                map().getTripulacion().getCargoTripulante().setCatNombre(source.getCatNombre());
                map().getVuelo().getAvion().setAviRegistro(source.getAviRegistro());
                map().getVuelo().getRuta().setRtaNombre(source.getRtaNombre());
            }
        });

        // Configuración personalizada PuntoRutaSaveDTO -> PuntoRuta
        modelMapper.addMappings(new PropertyMap<PuntoRutaSaveDTO, PuntoRuta>() {
            @Override
            protected void configure() {
                map().getRuta().setRtaId(source.getRtaId());
                map().getPuntoEscala().setPesId(source.getPesId());
            }
        });

        // Configuración personalizada PuntoRuta -> PuntoRutaSaveDTO
        modelMapper.addMappings(new PropertyMap<PuntoRuta, PuntoRutaSaveDTO>() {
            @Override
            protected void configure() {
                map().setRtaId(source.getRuta().getRtaId());
                map().setPesId(source.getPuntoEscala().getPesId());
            }
        });

        // Configuración personalizada PuntoRuta -> PuntoRutaListDTO
        modelMapper.addMappings(new PropertyMap<PuntoRuta, PuntoRutaListDTO>() {
            @Override
            protected void configure() {
                map().setRtaNombre(source.getRuta().getRtaNombre());
                map().setRtaPromedioMinutos(source.getRuta().getRtaPromedioMinutos());
                map().setPesNombrePunto(source.getPuntoEscala().getPesNombrePunto());
                map().setPesLongitud(source.getPuntoEscala().getPesLongitud());
                map().setPesLatitud(source.getPuntoEscala().getPesLatitud());
            }
        });

        // Configuración personalizada PuntoRutaListDTO -> PuntoRuta
        modelMapper.addMappings(new PropertyMap<PuntoRutaListDTO, PuntoRuta>() {
            @Override
            protected void configure() {
                map().getRuta().setRtaNombre(source.getRtaNombre());
                map().getRuta().setRtaPromedioMinutos(source.getRtaPromedioMinutos());
                map().getPuntoEscala().setPesNombrePunto(source.getPesNombrePunto());
                map().getPuntoEscala().setPesLongitud(source.getPesLongitud());
                map().getPuntoEscala().setPesLatitud(source.getPesLatitud());
            }
        });

        return modelMapper;

    }

}
