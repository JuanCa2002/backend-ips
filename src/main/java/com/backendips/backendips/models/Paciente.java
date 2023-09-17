package com.backendips.backendips.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="\"PACIENTES\"")
public class Paciente {

    @Id
    @Column(name="id_paciente")
    private int idPaciente;

    @ManyToOne
    @JoinColumn(name="codigo_persona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name="eps")
    private Eps eps;
}
