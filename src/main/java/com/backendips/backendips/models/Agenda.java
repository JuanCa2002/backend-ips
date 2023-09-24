package com.backendips.backendips.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "\"AGENDA\"")
public class Agenda {

    @Id
    @Column(name = "id_agenda")
    private int idAgenda;

    @ManyToOne
    @JoinColumn(name="codigo_cita")
    private Cita cita;

    @Column(name="fecha")
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name="id_medico")
    private Medico medico;
}
