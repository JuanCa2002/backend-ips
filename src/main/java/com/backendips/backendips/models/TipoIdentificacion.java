package com.backendips.backendips.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name ="\"TIPOS_IDENTIFICACION\"")
public class TipoIdentificacion {

    @Id
    private int codigo;

    private String tipo;

}
