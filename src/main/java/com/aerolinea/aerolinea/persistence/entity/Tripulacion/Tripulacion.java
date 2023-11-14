package com.aerolinea.aerolinea.persistence.entity.Tripulacion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tripulacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tripulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tri_id" , nullable = false , unique = true)
    private Long triId;

    @Column(name = "tri_nombre" , length = 100 ,nullable = false , unique = true)
    private String triNombre;

    @Column(name = "tri_apellido" , length = 100 ,nullable = false, unique = true)
    private String triApellido;

    @Column(name = "tri_codigo" , nullable = false , unique = true)
    private UUID triCodigo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cat_id", referencedColumnName = "cat_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CargoTripulante cargoTripulante;

    @OneToMany(mappedBy = "tripulacion", cascade = CascadeType.ALL)
    private List<TripulacionVuelo> tripulacionVuelo;

    @Column(name = "tri_f_create")
    private LocalDateTime triFCreate;

    @Column(name = "tri_f_update", nullable = true)
    private LocalDateTime triFUpdate;

    @Column(name = "tri_u_create", length = 100)
    private String triUCreate;

    @Column(name = "tri_u_update", length = 100, nullable = true)
    private String triUUpdate;

}
