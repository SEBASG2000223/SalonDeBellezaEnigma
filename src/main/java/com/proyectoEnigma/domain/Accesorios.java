package com.proyectoEnigma.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data //esta vara es para que cree set y get automaticamnetey metodos como el toString
@Entity
@Table(name = "Accesorios")
public class Accesorios implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_accesorios")
    private Long idAccesorios;
    private String nombreAccesorio;
    private String descripcion;
    private double precio;
    private int existencias;
    private String rutaImagen;
    private boolean activo;

}
