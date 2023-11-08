package com.backendips.backendips.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="\"PACIENTE\"")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="id_persona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name="id_eps")
    private Eps eps;
}
