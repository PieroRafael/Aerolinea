package com.aerolinea.aerolinea.persistence.entity.Avion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tipo_asiento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TipoAsiento{

    @Id
    @Column(name = "tpa_id" , nullable = false , unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tpaId;

    @Column(name = "tpa_nombre" , length = 100 , nullable = false, unique = true)
    private String tpaNombre;

    @OneToMany(mappedBy = "tipoAsiento", cascade = CascadeType.ALL)
    private List<Asiento> asiento;

    @Column(name = "tpa_f_create")
    private LocalDateTime tpaFCreate;

    @Column(name = "tpa_f_update", nullable = true)
    private LocalDateTime tpaFUpdate;

    @Column(name = "tpa_u_create", length = 100)
    private String tpaUCreate;

    @Column(name = "tpa_u_update", length = 100, nullable = true)
    private String tpaUUpdate;

}
