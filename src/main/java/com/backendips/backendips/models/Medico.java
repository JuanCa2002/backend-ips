package com.backendips.backendips.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="\"MEDICO\"")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="id_persona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name="id_especialidad")
    private EspecialidadMedico especialidad;

    @Column(name="tarjeta_profesional")
    private String tarjetaProfesional;
}
