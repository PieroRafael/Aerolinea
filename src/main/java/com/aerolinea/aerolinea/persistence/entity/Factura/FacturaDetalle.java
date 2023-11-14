package com.aerolinea.aerolinea.persistence.entity.Factura;

import com.aerolinea.aerolinea.persistence.entity.Avion.Asiento;
import com.aerolinea.aerolinea.persistence.entity.Pasajero.Pasajero;
import com.aerolinea.aerolinea.persistence.entity.Vuelo.Vuelo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "factura_detalle")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FacturaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fad_id" , nullable = false , unique = true)
    private Long fadId;

    @Column(name = "fad_code_ticket" , nullable = false , unique = true)
    private UUID fadCodeTicket;

    @Column(name = "fad_costo_ticket" , nullable = false , precision = 10 , scale = 2)
    private BigDecimal fadCostoTicket;

    @Column(name = "fad_descuento" , precision = 10 , scale = 2)
    private BigDecimal fadDescuento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vue_id", referencedColumnName = "vue_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Vuelo vuelo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cls_id", referencedColumnName = "cls_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ClaseSocial claseSocial;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ast_id", referencedColumnName = "ast_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Asiento asiento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pas_id", referencedColumnName = "pas_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Pasajero pasajero;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fac_id", referencedColumnName = "fac_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Factura factura;

    @Column(name = "fad_f_create")
    private LocalDateTime fadFCreate;

    @Column(name = "fad_f_update", nullable = true)
    private LocalDateTime fadFUpdate;

    @Column(name = "fad_u_create", length = 100)
    private String fadUCreate;

    @Column(name = "fad_u_update", length = 100, nullable = true)
    private String fadUUpdate;

}
