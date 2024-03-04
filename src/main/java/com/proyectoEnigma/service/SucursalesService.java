package com.proyectoEnigma.service;

import com.proyectoEnigma.domain.Sucursales;
import java.util.List;

public interface SucursalesService {
    
    //rECUPERA UNA LISTA DE LOS REGISTROS DE LA TABLA CATEGORIA

    public List<Sucursales> getSucursales(boolean activos);
    
    //Recupera un registro de la tbala sucursales buscando
    //el atributo idSucursales en la tabla
    
    public Sucursales getSucursales(Sucursales sucursales);
    
    //Elimina un registro de la tbla sucursales si 
    //encuentra un registro con el idSucursales pasado
    public void delete(Sucursales sucursales);
     //Si el objeto sucursales pasado por parametro tiene un 
    //valor en IdSucursales lo intenta actulizar
    //si no tiene valor idSucursales lo intenta actulizar
    public void save(Sucursales sucursales);
}
