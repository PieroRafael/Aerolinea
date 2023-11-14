package com.aerolinea.aerolinea.persistence.entity.Avion;

import com.aerolinea.aerolinea.persistence.entity.Factura.FacturaDetalle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "asiento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Asiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ast_id" , nullable = false , unique = true)
    private Long astId;

    @Column(name = "ast_nombre" , nullable = false , unique = true)
    private String astNombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "avi_id" , referencedColumnName = "avi_id" , nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Avion avion;

    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name = "tpa_id", referencedColumnName = "tpa_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TipoAsiento tipoAsiento;

    @OneToMany(mappedBy = "asiento", cascade = CascadeType.ALL)
    private List<FacturaDetalle> facturaDetalle;

    @Column(name = "ast_f_create")
    private LocalDateTime astFCreate;

    @Column(name = "ast_f_update", nullable = true)
    private LocalDateTime astFUpdate;

    @Column(name = "ast_u_create", length = 100)
    private String astUCreate;

    @Column(name = "ast_u_update", length = 100, nullable = true)
    private String astUUpdate;

    @Column(name = "ast_status", columnDefinition = "integer default 0")
    private int astStatus;

}
