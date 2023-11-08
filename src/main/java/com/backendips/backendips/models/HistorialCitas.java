package com.backendips.backendips.models;

import com.backendips.backendips.models.enums.Cambio;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "\"HISTORIAL_CITAS\"")
public class HistorialCitas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name ="fecha_modificacion")
    private LocalDate fechaModificacion;

    @Column(name ="hora_modificacion")
    private LocalTime horaModificacion;

    @ManyToOne
    @JoinColumn(name = "cita")
    private Cita cita;

    @ManyToOne
    @JoinColumn(name = "estado_anterior")
    private EstadoCita estadoAnterior;

    @ManyToOne
    @JoinColumn(name = "estado_actual")
    private EstadoCita estadoActual;

    @Enumerated(EnumType.STRING)
    private Cambio cambio;


}
