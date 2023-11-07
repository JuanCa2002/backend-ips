package com.backendips.backendips.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "\"TRABAJADOR\"")
public class Trabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cuenta_bancaria")
    private String cuentaBancaria;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;
}
