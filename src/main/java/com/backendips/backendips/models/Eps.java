package com.backendips.backendips.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="eps")
public class Eps {
    @Id
    private int id;

    private String nombre;

    private String nit;
}
