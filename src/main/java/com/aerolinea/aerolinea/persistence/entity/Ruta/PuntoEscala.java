package com.aerolinea.aerolinea.persistence.entity.Ruta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "punto_escala")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PuntoEscala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pes_id" , nullable = false , unique = true)
    private Long pesId;

    @Column(name = "pes_nombre_punto" , length = 50 ,nullable = false , unique = true)
    private String pesNombrePunto;

    @Column(name = "pes_longitud" , nullable = false)
    private Double pesLongitud;

    @Column(name = "pes_latitud" , nullable = false)
    private Double pesLatitud;

    @OneToMany(mappedBy = "puntoEscala", cascade = CascadeType.ALL)
    private List<PuntoRuta> puntoRuta;

    @Column(name = "pes_f_create")
    private LocalDateTime pesFCreate;

    @Column(name = "pes_f_update", nullable = true)
    private LocalDateTime pesFUpdate;

    @Column(name = "pes_u_create", length = 100)
    private String pesUCreate;

    @Column(name = "pes_u_update", length = 100, nullable = true)
    private String pesUUpdate;

}
