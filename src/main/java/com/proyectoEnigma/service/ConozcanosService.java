package com.proyectoEnigma.service;

import com.proyectoEnigma.domain.Conozcanos;
import java.util.List;

public interface ConozcanosService {
    
    //rECUPERA UNA LISTA DE LOS REGISTROS DE LA TABLA CATEGORIA

    public List<Conozcanos> getConozcanos();
    
    //Recupera un registro de la tbala conozcanos buscando
    //el atributo idConozcanos en la tabla
    
    public Conozcanos getConozcanos(Conozcanos conozcanos);
    
    //Elimina un registro de la tbla conozcanos si 
    //encuentra un registro con el idConozcanos pasado
    public void delete(Conozcanos conozcanos);
     //Si el objeto conozcanos pasado por parametro tiene un 
    //valor en IdConozcanos lo intenta actulizar
    //si no tiene valor idConozcanos lo intenta actulizar
    public void save(Conozcanos conozcanos);
}
