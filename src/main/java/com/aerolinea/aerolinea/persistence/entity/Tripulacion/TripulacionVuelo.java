package com.aerolinea.aerolinea.persistence.entity.Tripulacion;

import com.aerolinea.aerolinea.persistence.entity.Vuelo.Vuelo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tripulacion_vuelo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripulacionVuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tvu_id" , nullable = false , unique = true)
    private Long tvuId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tri_id", referencedColumnName = "tri_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Tripulacion tripulacion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vue_id", referencedColumnName = "vue_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Vuelo vuelo;

    @Column(name = "tvu_f_create")
    private LocalDateTime tvuFCreate;

    @Column(name = "tvu_f_update", nullable = true)
    private LocalDateTime tvuFUpdate;

    @Column(name = "tvu_u_create", length = 100)
    private String tvuUCreate;

    @Column(name = "tvu_u_update", length = 100, nullable = true)
    private String tvuUUpdate;

}
