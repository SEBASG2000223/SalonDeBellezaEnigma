package com.proyectoEnigma.controller;

import com.proyectoEnigma.domain.Accesorios;
import com.proyectoEnigma.service.AccesoriosService;
import com.proyectoEnigma.service.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/accesorios")
public class AccesoriosController {

    @Autowired
    private AccesoriosService accesoriosService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var listado = accesoriosService.getAccesorios(false);
        model.addAttribute("accesorios", listado);
        model.addAttribute("totalAccesorios", listado.size());
        return "accesorios/listado";
    }

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping("/guardar")
    public String guardar(Accesorios accesorios, @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            accesoriosService.save(accesorios);
            String rutaImagen = firebaseStorageService.cargaImagen(imagenFile, "accesorios", accesorios.getIdAccesorios());
            accesorios.setRutaImagen(rutaImagen);
        }
        accesoriosService.save(accesorios);
        return "redirect:/accesorios/inventarioAccesorios";
    }

    @GetMapping("/inventarioAccesorios")
    public String inventarioAccesorios(Model model) {
        var listado = accesoriosService.getAccesorios(false);
        model.addAttribute("accesorios", listado);
        model.addAttribute("totalAccesorios", listado.size());
        return "accesorios/inventarioAccesorios";
    }

    @GetMapping("/modificar/{idAccesorios}")
    public String modifica(Accesorios accesorios, Model model) {
        accesorios = accesoriosService.getAccesorios(accesorios);
        model.addAttribute("accesorios", accesorios);
        return "accesorios/modifica";
    }

    @GetMapping("/eliminar/{idAccesorios}")
    public String elimina(Accesorios accesorios) {
        accesoriosService.delete(accesorios);
        return "redirect:/accesorios/inventarioAccesorios";
    }

}
