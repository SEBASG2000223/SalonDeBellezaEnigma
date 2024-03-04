package com.proyectoEnigma.controller;

import com.proyectoEnigma.domain.Sucursales;
import com.proyectoEnigma.service.SucursalesService;
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
@RequestMapping("/sucursales")
public class SucursalesController {

    @Autowired
    private SucursalesService sucursalesService;

    @GetMapping("/listado")

    public String listado(Model model) {

        var listado = sucursalesService.getSucursales(false);

        model.addAttribute("sucursales", listado);
        model.addAttribute("totalSucursales", listado.size());

        return "/sucursales/listado";

    }
    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping("/guardar")
    public String guardar(Sucursales sucursales,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            sucursalesService.save(sucursales);

            String rutaImangen
                    = firebaseStorageService.cargaImagen(imagenFile, "sucursales", sucursales.getIdSucursales());
           

            sucursales.setRutaImagen(rutaImangen);

        }

        sucursalesService.save(sucursales);
        return "redirect:/sucursales/listado";

    }
    @GetMapping("/modificar/{idSucursales}")
    public String modifica(Sucursales sucursales, Model model){
        
        sucursales = sucursalesService.getSucursales(sucursales);
        model.addAttribute("sucursales", sucursales);
        return "/sucursales/modifica";
        
        
    }
        @GetMapping("/eliminar/{idSucursales}")
    public String elimina(Sucursales sucursales){
        
        sucursalesService.delete(sucursales);
           return "redirect:/sucursales/listado";
    }   
    
       
      
            

}
