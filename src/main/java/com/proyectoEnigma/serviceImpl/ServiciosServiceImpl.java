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
    private UsuarioService usuarioService;
    @Autowired
    private MessageSource messageSource;  //creado en semana 4...
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    public void agendarServicios(Servicios servicio, Usuario usuario) throws MessagingException {
        // Obtenemos el usuario asociado al servicio (puedes implementar esto según tu lógica)
        usuarioService.getUsuarioPorUsernameOCorreo(usuario.getUsername(), usuario.getCorreo());

        // Formateamos el mensaje con la información de la cita
        String mensaje = messageSource.getMessage(
                "servicio.correo.agendar",
                null, Locale.getDefault());
        mensaje = String.format(
                mensaje, usuario.getNombre(),
                servicio.getNombreServicio());

        // Asunto del correo
        String asunto = messageSource.getMessage(
                "servicio.mensaje.agendar",
                null, Locale.getDefault());

        // Enviamos el correo
        correoService.enviarCorreoHtml(usuario.getCorreo(), asunto, mensaje);
    }

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

    @Override
    public Model agendarServicios(Model model, Usuario usuario, Servicios servicios) throws MessagingException {
        // Mensaje del correo
        String mensaje = messageSource.getMessage(
                "servicio.correo.agendar",
                new Object[]{usuario.getNombre(), servicios.getNombreServicio()}, Locale.getDefault());

        // Asunto del correo
        String asunto = messageSource.getMessage(
                "servicio.correo.agendar.asunto",
                null, Locale.getDefault());

        // Enviamos el correo
        correoService.enviarCorreoHtml(usuario.getCorreo(), asunto, mensaje);

        // Añadimos los atributos al modelo
        model.addAttribute("titulo", "Agendar Servicio");
        model.addAttribute("mensaje", "Se ha agendado el servicio con éxito.");
        return model;
    }

}
