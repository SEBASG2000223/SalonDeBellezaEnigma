package com.proyectoEnigma.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "Conozcanos")
public class Conozcanos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conozcanos")
    private Long idConozcanos;

    private String descripcion;
    private String rutaImagen;
    
}
