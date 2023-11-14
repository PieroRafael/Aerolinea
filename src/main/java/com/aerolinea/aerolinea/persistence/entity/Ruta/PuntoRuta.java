package com.aerolinea.aerolinea.persistence.entity.Ruta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "punto_ruta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PuntoRuta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ptr_id" , nullable = false , unique = true)
    private Long ptrId;

    @Column(name = "ptr_orden_ruta" , length = 50 ,nullable = false , unique = true)
    private String ptrOrden;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rta_id" , referencedColumnName = "rta_id" , nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Ruta ruta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pes_id" , referencedColumnName = "pes_id" , nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PuntoEscala puntoEscala;

    @Column(name = "ptr_f_create")
    private LocalDateTime ptrFCreate;

    @Column(name = "ptr_f_update", nullable = true)
    private LocalDateTime ptrFUpdate;

    @Column(name = "ptr_u_create", length = 100)
    private String ptrUCreate;

    @Column(name = "ptr_u_update", length = 100, nullable = true)
    private String ptrUUpdate;

}
