package com.proyectoEnigma.controller;

import com.proyectoEnigma.service.AccesoriosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pruebas")
public class PruebasController {

    @Autowired
    private AccesoriosService accesoriosService;

    @GetMapping("/listado")
    public String listado(Model model) {

        // Obtener lista de productos
        var accesorios = accesoriosService.getAccesorios(false);
        model.addAttribute("accesorios", accesorios);

        return "/pruebas/listado";
    }

    @GetMapping("/listado2")
    public String listado2(Model model) {

        // Obtener lista de productos
        var accesorios = accesoriosService.getAccesorios(false);
        model.addAttribute("accesorios", accesorios);

        return "/pruebas/listado2";
    }

    @PostMapping("/query2")
    public String query2(
            @RequestParam("buscarAccesorios") String buscarAccesorios,
            Model model) {
        // Obtener lista de accesorios por descripción
        var accesorios = accesoriosService.consultaJPQLPorNombreAccesorio(buscarAccesorios);
        model.addAttribute("accesorios", accesorios);
        model.addAttribute("buscarAccesorios", buscarAccesorios);
        return "/pruebas/listado2";
    }
}
