package com.proyectoEnigma.controller;

import com.proyectoEnigma.domain.Servicios;
import com.proyectoEnigma.service.ServiciosService;
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
@RequestMapping("/servicios")
public class ServiciosController {

    @Autowired
    private ServiciosService serviciosService;

    @GetMapping("/listado")

    public String listado(Model model) {

        var listado = serviciosService.getServicios(false);

        model.addAttribute("servicios", listado);
        model.addAttribute("totalServicios", listado.size());

        return "/servicios/listado";

    }
    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping("/guardar")
    public String guardar(Servicios servicios,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            serviciosService.save(servicios);

            String rutaImangen
                    = firebaseStorageService.cargaImagen(imagenFile, "servicios", servicios.getIdServicios());
          
            servicios.setRutaImagen(rutaImangen);
        }
        serviciosService.save(servicios);
        return "redirect:/servicios/inventarioServicios";

    }
    @GetMapping("/inventarioServicios")
    public String inventarioServicios(Model model) {
        var listado = serviciosService.getServicios(false);
        model.addAttribute("servicios", listado);
        model.addAttribute("totalServicios", listado.size());
        return "servicios/inventarioServicios";
    }
    
    @GetMapping("/modificar/{idServicios}")
    public String modifica(Servicios servicios, Model model){
        
        servicios = serviciosService.getServicios(servicios);
        model.addAttribute("servicios", servicios);
        return "/servicios/modifica";
        
        
    }
        @GetMapping("/eliminar/{idServicios}")
    public String elimina(Servicios servicios){
        
        serviciosService.delete(servicios);
           return "redirect:/servicios/listado";
    }   
    
       
      
            

}
