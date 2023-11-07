package com.backendips.backendips.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "\"TIPO_IDENTIFICACION\"")
public class TipoIdentificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tipo;
}
