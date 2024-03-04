
package com.proyectoEnigma.service;

import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {
    
    public String cargaImagen(
            MultipartFile archivoLocalCliente, 
            String carpeta, 
            Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "techshopk-de30c.appspot.com";

    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "techshop";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "techshopk-de30c-firebase-adminsdk-xuk6n-4630c6e97a.json";
}


