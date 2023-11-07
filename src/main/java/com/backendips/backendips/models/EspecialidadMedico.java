package com.backendips.backendips.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "\"ESPECIALIDAD_MEDICO\"")
public class EspecialidadMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String especialidad;
}
