package com.backendips.backendips.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "\"ESTADO_CITA\"")
public class EstadoCita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String estado;
}
