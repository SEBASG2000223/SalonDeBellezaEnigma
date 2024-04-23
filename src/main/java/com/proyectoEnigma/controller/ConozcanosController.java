package com.proyectoEnigma.controller;

import com.proyectoEnigma.domain.Conozcanos;
import com.proyectoEnigma.service.ConozcanosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/conozcanos")
public class ConozcanosController {

    private final ConozcanosService conozcanosService;

    @Autowired
    public ConozcanosController(ConozcanosService conozcanosService) {
        this.conozcanosService = conozcanosService;
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        List<Conozcanos> conozcanos = conozcanosService.getConozcanos();
        model.addAttribute("conozcanos", conozcanos);
        return "conozcanos/listado";
    }

    @GetMapping("/informacion")
    public String informacion() {
        return "conozcanos/informacion";
    }

    @GetMapping("/contactenos")
    public String contactenos() {
        return "conozcanos/contactenos";
    }
}
