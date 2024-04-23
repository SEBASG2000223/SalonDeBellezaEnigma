package com.proyectoEnigma.serviceImpl;

import com.proyectoEnigma.domain.Conozcanos;
import com.proyectoEnigma.service.ConozcanosService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.proyectoEnigma.dao.ConozcanosDao;

@Service

public class ConozcanosServiceImpl
        implements ConozcanosService {

    @Autowired
    private ConozcanosDao conozcanosDao;

    @Override
    @Transactional(readOnly = true)//que el metodo accede a una base de datos y que la base es de solo lectura
    public List<Conozcanos> getConozcanos() {

        var listado = conozcanosDao.findAll();

        return listado;

    }

    @Override
    @Transactional(readOnly = true)//que el metodo accede a una base de datos y que la base es de solo lectura

    public Conozcanos getConozcanos(Conozcanos conozcanos) {
        return conozcanosDao.findById(conozcanos.getIdConozcanos()).orElse(null);
    }

    @Override
    @Transactional

    public void delete(Conozcanos conozcanos) {
        conozcanosDao.delete(conozcanos);
    }

    @Override
    @Transactional

    public void save(Conozcanos conozcanos) {

        conozcanosDao.save(conozcanos);
    }

}
