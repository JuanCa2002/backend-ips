package com.backendips.backendips.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="\"MEDICOS\"")
public class Medico {

    @Id
    @Column(name="id_medico")
    private int idMedico;

    @ManyToOne
    @JoinColumn(name="codigo_persona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name="especialidad")
    private EspecialidadMedico especialidadMedico;

    @Column(name="tarjeta_profesional")
    private String tarjetaProfesional;


}
