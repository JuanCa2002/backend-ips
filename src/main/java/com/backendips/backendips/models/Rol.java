package com.backendips.backendips.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="\"ROL\"")
public class Rol {

    @Id
    private int codigo;

    @ManyToOne
    @JoinColumn(name="nombre_id")
    private NombreRol nombreRol;

}
