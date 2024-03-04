package com.proyectoEnigma.service;

import com.proyectoEnigma.domain.Servicios;
import java.util.List;

public interface ServiciosService {
    
    //rECUPERA UNA LISTA DE LOS REGISTROS DE LA TABLA CATEGORIA

    public List<Servicios> getServicios(boolean activos);
    
    //Recupera un registro de la tbala servicios buscando
    //el atributo idServicios en la tabla
    
    public Servicios getServicios(Servicios servicios);
    
    //Elimina un registro de la tbla servicios si 
    //encuentra un registro con el idServicios pasado
    public void delete(Servicios servicios);
     //Si el objeto servicios pasado por parametro tiene un 
    //valor en IdServicios lo intenta actulizar
    //si no tiene valor idServicios lo intenta actulizar
    public void save(Servicios servicios);
}
