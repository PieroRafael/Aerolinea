package com.aerolinea.aerolinea.persistence.entity.Ruta;

import com.aerolinea.aerolinea.persistence.entity.Vuelo.Vuelo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ruta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rta_id" , nullable = false , unique = true)
    private Long rtaId;

    @Column(name = "rta_nombre" , length = 100 , nullable = false , unique = true)
    private String rtaNombre;

    @Column(name = "rta_pro_minutos" , nullable = false)
    private Integer rtaPromedioMinutos;

    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL)
    private List<Vuelo> vuelo;

    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL)
    private List<PuntoRuta> puntoRuta;

    @Column(name = "rta_f_create")
    private LocalDateTime rtaFCreate;

    @Column(name = "rta_f_update", nullable = true)
    private LocalDateTime rtaFUpdate;

    @Column(name = "rta_u_create", length = 100)
    private String rtaUCreate;

    @Column(name = "rta_u_update", length = 100, nullable = true)
    private String rtaUUpdate;

}
