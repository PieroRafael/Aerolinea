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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "marca")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Marca {

    @Id
    @Column(name = "mar_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long marId;

    @Column(name = "mar_nombre", length = 100, nullable = false, unique = true)
    private String marNombre;

    @Column(name = "mar_f_create")
    private LocalDateTime marFCreate;

    @Column(name = "mar_f_update", nullable = true)
    private LocalDateTime marFUpdate;

    @Column(name = "mar_u_create", length = 100)
    private String marUCreate;

    @Column(name = "mar_u_update", length = 100, nullable = true)
    private String marUUpdate;

    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
    private List<Avion> avion;

}
