package com.jaeverba.jv.controller;

import com.jaeverba.jv.controller.send_in_blue.email.transactional.Email;
import com.jaeverba.jv.entities.Solicitud;
import com.jaeverba.jv.services.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    //@RequestMapping(value = "/form/solicitud", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    //public String create(Solicitud solicitudes) {
    @RequestMapping(value = "/form/solicitud", method = RequestMethod.POST)
    public String create(@RequestBody Solicitud solicitud) {

        int resultado = solicitudService.createSolicitud(solicitud);

        boolean bul = resultado == 1? Email.emailContactMeConfirm(solicitud).send() : false;

        boolean borrado = resultado == 1 && !bul? solicitudService.delete(solicitud.getEmail()) : false;

        //return String.valueOf(bul);
        return (resultado == 1) && bul? "1" : "0";
    }

    @RequestMapping(value = "/form/solicitud", method = RequestMethod.DELETE, params = "email")
    public String delete(@RequestParam String email) {

        boolean borrado = solicitudService.delete(email);

        return borrado? "1" : "0";
    }

    @RequestMapping(value = "/form/solicitudes", method = RequestMethod.GET)
    public List<Solicitud> getAll() {
        return solicitudService.getAll();
    }
}
