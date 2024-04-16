package com.proyectoEnigma.serviceImpl;

import com.proyectoEnigma.dao.ServiciosDao;
import com.proyectoEnigma.domain.Servicios;
import com.proyectoEnigma.domain.Usuario;
import com.proyectoEnigma.service.CorreoService;
import com.proyectoEnigma.service.ServiciosService;
import com.proyectoEnigma.service.UsuarioService;
import jakarta.mail.MessagingException;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

@Service

public class ServiciosServiceImpl
        implements ServiciosService {

    @Autowired
    private ServiciosDao serviciosDao;
    @Autowired
    private CorreoService correoService;
    @Autowired
    private CorreoService serviciosService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private MessageSource messageSource;  //creado en semana 4...

    @Override
    @Transactional(readOnly = true)//que el metodo accede a una base de datos y que la base es de solo lectura
    public List<Servicios> getServicios(boolean activos) {

        var listado = serviciosDao.findAll();

        if (activos) {//si solo q uiero los activos
            listado.removeIf(c -> !c.isActivo());

        }

        return listado;

    }

    @Override
    @Transactional(readOnly = true)//que el metodo accede a una base de datos y que la base es de solo lectura

    public Servicios getServicios(Servicios servicios) {
        return serviciosDao.findById(servicios.getIdServicios()).orElse(null);
    }

    @Override
    @Transactional

    public void delete(Servicios servicios) {
        serviciosDao.delete(servicios);
    }

    @Override
    @Transactional

    public void save(Servicios servicios) {

        serviciosDao.save(servicios);
    }
    
    public String obtenerNombreServicio(Servicios servicio) {
    if (servicio != null) {
        return servicio.getNombreServicio();
    } else {
        return null;
    }
}
    
    

    @Override
    public Model agendarServicios(Model model, Usuario usuario, Servicios servicios) throws MessagingException {

        String nombreServicio = obtenerNombreServicio(servicios);

        enviarAgendarServicios(usuario, nombreServicio);

        // Añadimos los atributos al modelo
        model.addAttribute("titulo", "Agendar Servicio");
        model.addAttribute("mensaje", "Se ha agendado el servicio con éxito.");
        return model;
    }
    
    

    @Value("${servidor.http}")
    private String servidor;

    public void enviarAgendarServicios(Usuario usuario, String nombreServicio) throws MessagingException {
        // Mensaje del correo
        String mensaje = messageSource.getMessage(
                "servicio.correo.agendar",
                null, Locale.getDefault());

        // Formateamos la cadena de mensaje con el nombre del usuario y el nombre del servicio
        mensaje = String.format(mensaje, usuario.getNombre(), nombreServicio, servidor);

        String asunto = messageSource.getMessage(
                "servicio.correo.agendar.asunto",
                null, Locale.getDefault());

        // Enviamos el correo
        correoService.enviarCorreoHtml(usuario.getCorreo(), asunto, mensaje);
    }
}
