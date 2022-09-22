package com.jaeverba.jv.services;

import com.jaeverba.jv.entities.Solicitud;
import com.jaeverba.jv.repositories.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class SolicitudService {
    @Autowired
    private SolicitudRepository solicitudRepository;

    @Transactional
    public int createSolicitud(Solicitud solicitud) {
        try {
            if (!solicitudRepository.existsByEmail(solicitud.getEmail())) {
                solicitud.setId(null == solicitudRepository.findMaxId()? 0 : solicitudRepository.findMaxId() + 1);
                solicitud.setAprobado(false);
                solicitud.setHora(DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now()));
                solicitud.setFecha(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now()));
                solicitudRepository.save(solicitud);
                return 1;
            } else return 0;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Solicitud> getAll() {
        return solicitudRepository.findAll();
    }
}
