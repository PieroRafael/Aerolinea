package com.aerolinea.aerolinea.persistence.entity.Avion;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.aerolinea.aerolinea.persistence.entity.Avion.Avion;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "modelo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Modelo {

    @Id
    @Column(name = "mod_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long modId;

    @Column(name = "mod_nombre", length = 100, nullable = false, unique = true)
    private String modNombre;

    @Column(name = "mod_f_create")
    private LocalDateTime modFCreate;

    @Column(name = "mod_f_update", nullable = true)
    private LocalDateTime modFUpdate;

    @Column(name = "mod_u_create", length = 100)
    private String modUCreate;

    @Column(name = "mod_u_update", length = 100, nullable = true)
    private String modUUpdate;

    @OneToMany(mappedBy = "modelo", cascade = CascadeType.ALL)
    private List<Avion> avion;

}
