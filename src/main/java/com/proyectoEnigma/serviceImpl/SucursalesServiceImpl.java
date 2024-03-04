package com.proyectoEnigma.serviceImpl;

import com.proyectoEnigma.domain.Sucursales;
import com.proyectoEnigma.service.SucursalesService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.proyectoEnigma.dao.ConozcanosDao;

@Service

public class SucursalesServiceImpl
        implements SucursalesService {

    @Autowired
    private ConozcanosDao sucursalesDao;

    @Override
    @Transactional(readOnly = true)//que el metodo accede a una base de datos y que la base es de solo lectura
    public List<Sucursales> getSucursales(boolean activos) {

        var listado = sucursalesDao.findAll();

        if (activos) {//si solo q uiero los activos
            listado.removeIf(c -> !c.isActivo());

        }

        return listado;

    }

    @Override
    @Transactional(readOnly = true)//que el metodo accede a una base de datos y que la base es de solo lectura

    public Sucursales getSucursales(Sucursales sucursales) {
        return sucursalesDao.findById(sucursales.getIdSucursales()).orElse(null);
    }

    @Override
    @Transactional

    public void delete(Sucursales sucursales) {
        sucursalesDao.delete(sucursales);
    }

    @Override
    @Transactional

    public void save(Sucursales sucursales) {

        sucursalesDao.save(sucursales);
    }

}
