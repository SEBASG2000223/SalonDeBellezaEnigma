package com.proyectoEnigma.controller;

import com.proyectoEnigma.domain.Conozcanos;
import com.proyectoEnigma.service.ConozcanosService;
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
@RequestMapping("/conozcanos")
public class ConozcanosController {

    @Autowired
    private ConozcanosService conozcanosService;

    @GetMapping("/listado")

    public String listado(Model model) {

        var listado = conozcanosService.getConozcanos(false);

        model.addAttribute("conozcanos", listado);
        model.addAttribute("totalConozcanos", listado.size());

        return "/conozcanos/listado";

    }
    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping("/guardar")
    public String guardar(Conozcanos conozcanos,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            conozcanosService.save(conozcanos);

            String rutaImangen
                    = firebaseStorageService.cargaImagen(imagenFile, "conozcanos", conozcanos.getIdConozcanos());
           

            conozcanos.setRutaImagen(rutaImangen);

        }

        conozcanosService.save(conozcanos);
        return "redirect:/conozcanos/listado";

    }
    @GetMapping("/modificar/{idConozcanos}")
    public String modifica(Conozcanos conozcanos, Model model){
        
        conozcanos = conozcanosService.getConozcanos(conozcanos);
        model.addAttribute("conozcanos", conozcanos);
        return "/conozcanos/modifica";
        
        
    }
        @GetMapping("/eliminar/{idConozcanos}")
    public String elimina(Conozcanos conozcanos){
        
        conozcanosService.delete(conozcanos);
           return "redirect:/conozcanos/listado";
    }   
    
       
      
            

}
