package com.backendips.backendips.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="usuarios")
public class Usuario {

    @Id
    @Column(name="id_usuario")
    private int idUsuario;

    @ManyToOne
    @JoinColumn(name="codigo_persona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name="rol")
    private Rol rol;

}
