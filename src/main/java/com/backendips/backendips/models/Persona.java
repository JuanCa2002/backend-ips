package com.backendips.backendips.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "\"PERSONA\"")
public class Persona implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private String apellido;

    @ManyToOne
    @JoinColumn(name = "id_tipo_identificacion")
    private TipoIdentificacion tipoIdentificacion;

    @Column(name = "numero_documento")
    private String numeroDocumento;

    private String password;

    private String telefono;

    private String correo;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((rol.getNombreRol().getRol())));
    }

    @Override
    public String getUsername() {
        return numeroDocumento;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
