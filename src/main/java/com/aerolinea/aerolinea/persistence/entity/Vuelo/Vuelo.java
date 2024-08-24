package com.aerolinea.aerolinea.persistence.entity.Vuelo;

import com.aerolinea.aerolinea.persistence.entity.Avion.Avion;
import com.aerolinea.aerolinea.persistence.entity.Factura.FacturaDetalle;
import com.aerolinea.aerolinea.persistence.entity.Ruta.Ruta;
import com.aerolinea.aerolinea.persistence.entity.Tripulacion.TripulacionVuelo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "vuelo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vue_id" , nullable = false , unique = true)
    private Long vueId;

    @Column(name = "vueCod" , nullable = false , unique = true, columnDefinition = "CHAR(36)")
    private String vueCod;

    @Column(name = "vue_f_h_partida" , nullable = false)
    private ZonedDateTime vueFHPartida;

    @Column(name = "vue_f_h_llegada" , nullable = false)
    private ZonedDateTime vueFHLlegada;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "avi_id" , referencedColumnName = "avi_id" , nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Avion avion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rta_id" , referencedColumnName = "rta_id" , nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Ruta ruta;

    @OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL)
    private List<FacturaDetalle> facturaDetalle;

    @OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL)
    private List<TripulacionVuelo> tripulacionVuelo;

    @Column(name = "vue_f_create")
    private LocalDateTime vueFCreate;

    @Column(name = "vue_f_update", nullable = true)
    private LocalDateTime vueFUpdate;

    @Column(name = "vue_u_create", length = 100)
    private String vueUCreate;

    @Column(name = "vue_u_update", length = 100, nullable = true)
    private String vueUUpdate;

    @Column(name = "vue_status", columnDefinition = "integer default 0")
    private int vueStatus;

}
