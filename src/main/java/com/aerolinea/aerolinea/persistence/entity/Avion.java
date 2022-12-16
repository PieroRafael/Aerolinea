package com.aerolinea.aerolinea.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "avion")
@NoArgsConstructor
@Data
public class Avion {

    @Id
    @Column(name = "avi_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aviId;

    @Column(name = "avi_registro", length = 50, nullable = false, unique = true)
    private String aviRegistro;

    @Column(name = "avi_cantidad_asientos", nullable = false)
    private int aviCantidadAsientos;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "mar_id", referencedColumnName = "mar_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Marca marca;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "mod_id", referencedColumnName = "mod_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Modelo modelo;

    @Column(name = "avi_f_create")
    private LocalDateTime aviFCreate;

    @Column(name = "avi_f_update", nullable = true)
    private LocalDateTime aviFUpdate;

    @Column(name = "avi_u_create", length = 100)
    private String aviUCreate;

    @Column(name = "avi_u_update", length = 100, nullable = true)
    private String aviUUpdate;

    @Column(name = "avi_status", columnDefinition = "integer default 0")
    private int aviStatus;

}
