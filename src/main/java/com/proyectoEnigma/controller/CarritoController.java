package com.proyectoEnigma.controller;

import com.proyectoEnigma.domain.Carrito;
import com.proyectoEnigma.service.CarritoService;
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
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @GetMapping("/listado")

    public String listado(Model model) {

        var listado = carritoService.getCarrito(false);

        model.addAttribute("carrito", listado);
        model.addAttribute("totalCarrito", listado.size());

        return "/carrito/listado";

    }
    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @PostMapping("/guardar")
    public String guardar(Carrito carrito,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            carritoService.save(carrito);

            String rutaImangen
                    = firebaseStorageService.cargaImagen(imagenFile, "carrito", carrito.getIdCarrito());
           

            carrito.setRutaImagen(rutaImangen);

        }

        carritoService.save(carrito);
        return "redirect:/carrito/listado";

    }
    @GetMapping("/modificar/{idCarrito}")
    public String modifica(Carrito carrito, Model model){
        
        carrito = carritoService.getCarrito(carrito);
        model.addAttribute("carrito", carrito);
        return "/carrito/modifica";
        
        
    }
        @GetMapping("/eliminar/{idCarrito}")
    public String elimina(Carrito carrito){
        
        carritoService.delete(carrito);
           return "redirect:/carrito/listado";
    }   
    
       
      
            

}
