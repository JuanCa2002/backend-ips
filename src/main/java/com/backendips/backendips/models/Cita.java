package com.backendips.backendips.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "\"CITAS\"")
public class Cita {

    @Id
    @Column(name="Codigo")
    private int codigo;

    @ManyToOne
    @JoinColumn(name="id_paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name="id_medico")
    private Medico medico;


    @JoinColumn(name="fecha")
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name="id_estado_cita")
    private EstadoCita estadoCita;
}
