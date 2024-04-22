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


    @GetMapping("/listado")
    public String listado() {

        return "/conozcanos/listado";

    }
  
    @GetMapping("/informacion")
    public String informacion() {

     
        return "/conozcanos/informacion";

    }
    @GetMapping("/contactenos")
    public String contactenos() {

     
        return "/conozcanos/contactenos";

    }
       
      
            

}
