package com.aerolinea.aerolinea.persistence.entity.Usuario;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tipo_usuario")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TipoUsuario {

    @Id
    @Column(name = "tpu_id" , nullable = false , unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tpuId;

    @Column(name = "tpu_nombre" , nullable = false , unique = true)
    private String tpuNombre;

    @OneToOne(mappedBy = "tipoUsuario")
    private Usuario usuario;

    @Column(name = "tpu_f_create")
    private LocalDateTime tpuFCreate;

    @Column(name = "tpu_f_update", nullable = true)
    private LocalDateTime tpuFUpdate;

}
