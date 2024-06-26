package com.proyectoEnigma.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data //esta vara es para que cree set y get automaticamnetey metodos como el toString
@Entity
@Table(name = "Carrito")
public class Carrito implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrito")
    private Long idCarrito;
    private String nombreCarrito;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

}
