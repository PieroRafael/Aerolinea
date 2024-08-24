package com.aerolinea.aerolinea.persistence.entity.Factura;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "clase_social")
@Data
@NoArgsConstructor
@AllArgsConstructor 
@Builder
public class ClaseSocial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cls_id" , nullable = false , unique = true)
    private Long clsId;

    @Column(name = "cls_nombre" , length = 30 ,nullable = false , unique = true)
    private String clsNombre;

    @OneToMany(mappedBy = "claseSocial", cascade = CascadeType.ALL)
    private List<FacturaDetalle> facturaDetalle;

    @Column(name = "cls_f_create")
    private LocalDateTime clsFCreate;

    @Column(name = "cls_f_update", nullable = true)
    private LocalDateTime clsFUpdate;

    @Column(name = "cls_u_create", length = 100)
    private String clsUCreate;

    @Column(name = "cls_u_update", length = 100, nullable = true)
    private String clsUUpdate;

}
