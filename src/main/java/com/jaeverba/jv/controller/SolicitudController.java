package com.jaeverba.jv.controller;

import com.jaeverba.jv.entities.Solicitud;
import com.jaeverba.jv.services.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    @RequestMapping(value = "/form/solicitud", method = RequestMethod.POST)
    public String create(@RequestBody Solicitud solicitudes) {
        return String.valueOf(solicitudService.createSolicitud(solicitudes));
    }

    @RequestMapping(value = "/form/solicitudes", method = RequestMethod.GET)
    public List<Solicitud> getAll() {
        return solicitudService.getAll();
    }
}
