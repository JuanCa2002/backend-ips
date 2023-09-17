package com.backendips.backendips.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="\"PERSONA\"")
public class Persona {

    @Id
    private int codigo;

    private String nombre;

    private String apellido;

    @ManyToOne
    @JoinColumn(name="tipo_identificacion")
    private TipoIdentificacion tipo_identificacion;

    private String numero_documento;

    private String telefono;

    private String correo;




}
