package com.proyectoEnigma.serviceImpl;

import com.proyectoEnigma.dao.ServiciosDao;
import com.proyectoEnigma.domain.Servicios;
import com.proyectoEnigma.service.ServiciosService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class ServiciosServiceImpl
        implements ServiciosService {

    @Autowired
    private ServiciosDao serviciosDao;

    @Override
    @Transactional(readOnly = true)//que el metodo accede a una base de datos y que la base es de solo lectura
    public List<Servicios> getServicios(boolean activos) {

        var listado = serviciosDao.findAll();

        if (activos) {//si solo q uiero los activos
            listado.removeIf(c -> !c.isActivo());

        }

        return listado;

    }

    @Override
    @Transactional(readOnly = true)//que el metodo accede a una base de datos y que la base es de solo lectura

    public Servicios getServicios(Servicios servicios) {
        return serviciosDao.findById(servicios.getIdServicios()).orElse(null);
    }

    @Override
    @Transactional

    public void delete(Servicios servicios) {
        serviciosDao.delete(servicios);
    }

    @Override
    @Transactional

    public void save(Servicios servicios) {

        serviciosDao.save(servicios);
    }

}
