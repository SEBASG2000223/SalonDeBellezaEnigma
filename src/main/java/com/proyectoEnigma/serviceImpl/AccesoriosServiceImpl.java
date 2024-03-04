package com.proyectoEnigma.serviceImpl;

import com.proyectoEnigma.dao.AccesoriosDao;
import com.proyectoEnigma.domain.Accesorios;
import com.proyectoEnigma.service.AccesoriosService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class AccesoriosServiceImpl
        implements AccesoriosService {

    @Autowired
    private AccesoriosDao accesoriosDao;

    @Override
    @Transactional(readOnly = true)//que el metodo accede a una base de datos y que la base es de solo lectura
    public List<Accesorios> getAccesorios(boolean activos) {

        var listado = accesoriosDao.findAll();

        if (activos) {//si solo q uiero los activos
            listado.removeIf(c -> !c.isActivo());

        }

        return listado;

    }

    @Override
    @Transactional(readOnly = true)//que el metodo accede a una base de datos y que la base es de solo lectura

    public Accesorios getAccesorios(Accesorios accesorios) {
        return accesoriosDao.findById(accesorios.getIdAccesorios()).orElse(null);
    }

    @Override
    @Transactional

    public void delete(Accesorios accesorios) {
        accesoriosDao.delete(accesorios);
    }

    @Override
    @Transactional

    public void save(Accesorios accesorios) {

        accesoriosDao.save(accesorios);
    }

}
