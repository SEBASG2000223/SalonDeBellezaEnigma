package com.proyectoEnigma.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data // Esta anotación es para que se creen automáticamente los métodos getter, setter y otros métodos, como el toString
@Entity
@Table(name = "Sucursales")
public class Sucursales implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursales")
    private Long idSucursales;

    private String nombreSucursal;
    private String descripcion;
    private String rutaImagen;
    private String ubicacion; // Nueva columna

    private boolean activo;
}
