package com.proyectoEnigma.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class Item extends Accesorios {
    private int cantidad;

    public Item(Accesorios p) {
        super.setActivo(p.isActivo());
        super.setDescripcion(p.getDescripcion());
        super.setExistencias(p.getExistencias());
        super.setIdAccesorios(p.getIdAccesorios());
        super.setPrecio(p.getPrecio());
        super.setRutaImagen(p.getRutaImagen());
        this.cantidad = 0;

    }
}
