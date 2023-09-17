package com.backendips.backendips.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="nombre_rol")
public class NombreRol {

    @Id
    private int id;

    private String nombre;

}
