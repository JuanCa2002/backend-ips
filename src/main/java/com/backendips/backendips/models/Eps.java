package com.backendips.backendips.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "\"EPS\"")
public class Eps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String eps;

    private String nit;
}
