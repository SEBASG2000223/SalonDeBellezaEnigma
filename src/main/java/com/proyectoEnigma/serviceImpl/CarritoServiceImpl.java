package com.proyectoEnigma.serviceImpl;

import com.proyectoEnigma.dao.CarritoDao;
import com.proyectoEnigma.domain.Carrito;
import com.proyectoEnigma.service.CarritoService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class CarritoServiceImpl
        implements CarritoService {

    @Autowired
    private CarritoDao carritoDao;

    @Override
    @Transactional(readOnly = true)//que el metodo accede a una base de datos y que la base es de solo lectura
    public List<Carrito> getCarrito(boolean activos) {

        var listado = carritoDao.findAll();

        if (activos) {//si solo q uiero los activos
            listado.removeIf(c -> !c.isActivo());

        }

        return listado;

    }

    @Override
    @Transactional(readOnly = true)//que el metodo accede a una base de datos y que la base es de solo lectura

    public Carrito getCarrito(Carrito carrito) {
        return carritoDao.findById(carrito.getIdCarrito()).orElse(null);
    }

    @Override
    @Transactional

    public void delete(Carrito carrito) {
        carritoDao.delete(carrito);
    }

    @Override
    @Transactional

    public void save(Carrito carrito) {

        carritoDao.save(carrito);
    }

}
