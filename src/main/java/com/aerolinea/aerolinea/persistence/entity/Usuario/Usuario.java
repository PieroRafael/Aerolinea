package com.aerolinea.aerolinea.persistence.entity.Usuario;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@Data
public class Usuario {

    @Id
    @Column(name = "usu_id" , unique = true , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuId;

    @Column(name = "usu_email" , length = 50, unique = true , nullable = false)
    private String usuEmail;

    @Column(name = "usu_contraseña" , length = 50, nullable = false)
    private String usuContraseña;

    @OneToOne
    @JoinColumn(name = "tpu_id", referencedColumnName = "tpu_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TipoUsuario tipoUsuario;

    @Column(name = "usu_f_create")
    private LocalDateTime usuFCreate;

    @Column(name = "usu_f_update", nullable = true)
    private LocalDateTime usuFUpdate;

    @Column(name = "usu_status", columnDefinition = "integer default 0")
    private int usuStatus;

}
