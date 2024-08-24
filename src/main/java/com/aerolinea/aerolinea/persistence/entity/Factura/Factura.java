package com.aerolinea.aerolinea.persistence.entity.Factura;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "factura")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fac_id" , nullable = false , unique = true)
    private Long facId;

    @Column(name = "fac_cod" , nullable = false , unique = true , columnDefinition = "CHAR(36)")
    private String facCod;

    @Column(name = "fac_costo_total" , nullable = false , precision = 10 , scale = 2)
    private BigDecimal facCostoTotal;

    @Column(name = "fac_total_impuesto" , nullable = false , precision = 10 , scale = 2)
    private BigDecimal facTotalImpuesto;

    @Column(name = "fac_fecha" , nullable = false)
    private LocalDate facFecha;

    // Facturado (investigar un poco más acerca de este campo para las facturas)

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<FacturaDetalle> facturaDetalle;

    @Column(name = "fac_f_create")
    private LocalDateTime facFCreate;

    @Column(name = "fac_f_update", nullable = true)
    private LocalDateTime facFUpdate;

    @Column(name = "fac_u_create", length = 100)
    private String facUCreate;

    @Column(name = "fac_u_update", length = 100, nullable = true)
    private String facUUpdate;

}
