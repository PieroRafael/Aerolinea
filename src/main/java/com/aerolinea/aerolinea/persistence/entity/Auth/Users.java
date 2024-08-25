package com.aerolinea.aerolinea.persistence.entity.Auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "usuario", uniqueConstraints = { @UniqueConstraint(columnNames = "user_email"),
        @UniqueConstraint(columnNames = "user_nickname") })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Users {

    @Id
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID")
    @Column(name = "user_id" , nullable = false , unique = true , updatable = false, columnDefinition = "UUID")
    private UUID userId;

    @Column(name = "user_email", length = 100, nullable = false, unique = true)
    private String userEmail;

    @Column(name = "user_nickname", length = 100, nullable = false, unique = true)
    private String userNickname;

    @Column(name = "user_password", length = 100, nullable = false)
    private String userPassword;

    @Column(name = "user_photo", length = 100)
    private String userPhoto;

    @Column(name = "user_state", nullable = false, columnDefinition = "integer default 1")
    private Integer userState;

    @Column(name = "user_f_create", updatable = false)
    @CreationTimestamp
    private Timestamp userFCreate;

    @Column(name = "user_f_update", insertable = false)
    @UpdateTimestamp
    private Timestamp userFUpdate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Users(String userEmail, String userNickname, String userPassword) {
        this.userEmail = userEmail;
        this.userNickname = userNickname;
        this.userPassword = userPassword;
        this.userState = 1;
    }

}
