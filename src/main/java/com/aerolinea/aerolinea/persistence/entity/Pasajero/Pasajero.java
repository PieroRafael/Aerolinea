package com.aerolinea.aerolinea.persistence.entity.Pasajero;

import com.aerolinea.aerolinea.persistence.entity.Factura.FacturaDetalle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pasajero")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pasajero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pas_id" , nullable = false , unique = true)
    private Long pasId;

    @Column(name = "pas_nombre" , length = 100 ,nullable = false , unique = true)
    private String pasNombre;

    @Column(name = "pas_apellido" , length = 100 ,nullable = false, unique = true)
    private String pasApellido;

    @Column(name = "pas_edad" , nullable = false)
    private int pasEdad;

    @Enumerated(EnumType.STRING)
    @Column(name = "pas_genero" , length = 9 , nullable = false)
    private Genero pasGenero;

    @OneToMany(mappedBy = "pasajero", cascade = CascadeType.ALL)
    private List<FacturaDetalle> facturaDetalle;

    @Column(name = "pas_f_create")
    private LocalDateTime pasFCreate;

    @Column(name = "pas_f_update", nullable = true)
    private LocalDateTime pasFUpdate;

    @Column(name = "pas_u_create", length = 100)
    private String pasUCreate;

    @Column(name = "pas_u_update", length = 100, nullable = true)
    private String pasUUpdate;

}
