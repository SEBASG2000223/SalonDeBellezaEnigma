package com.proyectoEnigma.service;

import com.proyectoEnigma.domain.Carrito;
import java.util.List;

public interface CarritoService {
    
    //rECUPERA UNA LISTA DE LOS REGISTROS DE LA TABLA CATEGORIA

    public List<Carrito> getCarrito(boolean activos);
    
    //Recupera un registro de la tbala carrito buscando
    //el atributo idCarrito en la tabla
    
    public Carrito getCarrito(Carrito carrito);
    
    //Elimina un registro de la tbla carrito si 
    //encuentra un registro con el idCarrito pasado
    public void delete(Carrito carrito);
     //Si el objeto carrito pasado por parametro tiene un 
    //valor en IdCarrito lo intenta actulizar
    //si no tiene valor idCarrito lo intenta actulizar
    public void save(Carrito carrito);
}
