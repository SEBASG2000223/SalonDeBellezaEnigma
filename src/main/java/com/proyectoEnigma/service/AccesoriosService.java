package com.proyectoEnigma.service;

import com.proyectoEnigma.domain.Accesorios;
import java.util.List;

public interface AccesoriosService {
    
    //rECUPERA UNA LISTA DE LOS REGISTROS DE LA TABLA CATEGORIA

    public List<Accesorios> getAccesorios(boolean activos);
    
    //Recupera un registro de la tbala accesorios buscando
    //el atributo idAccesorios en la tabla
    
    public Accesorios getAccesorios(Accesorios accesorios);
    
    //Elimina un registro de la tbla accesorios si 
    //encuentra un registro con el idAccesorios pasado
    public void delete(Accesorios accesorios);
     //Si el objeto accesorios pasado por parametro tiene un 
    //valor en IdAccesorios lo intenta actulizar
    //si no tiene valor idAccesorios lo intenta actulizar
    public void save(Accesorios accesorios);
}
