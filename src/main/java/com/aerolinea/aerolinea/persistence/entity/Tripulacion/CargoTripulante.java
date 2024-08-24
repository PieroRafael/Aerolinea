package com.aerolinea.aerolinea.persistence.entity.Tripulacion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cargo_tripulante")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CargoTripulante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id" , nullable = false , unique = true)
    private Long catId;

    @Column(name = "cat_nombre" , nullable = false , unique = true , length = 25)
    private String catNombre;

    @OneToMany(mappedBy = "cargoTripulante", cascade = CascadeType.ALL)
    private List<Tripulacion> tripulacion;

    @Column(name = "cat_f_create")
    private LocalDateTime catFCreate;

    @Column(name = "cat_f_update", nullable = true)
    private LocalDateTime catFUpdate;

    @Column(name = "cat_u_create", length = 100)
    private String catUCreate;

    @Column(name = "cat_u_update", length = 100, nullable = true)
    private String catUUpdate;

}
