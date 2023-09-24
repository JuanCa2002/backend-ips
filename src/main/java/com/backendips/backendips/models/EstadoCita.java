package com.backendips.backendips.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "\"ESTADO_CITA\"")
public class EstadoCita {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="nombre")
    private String nombre;

}
