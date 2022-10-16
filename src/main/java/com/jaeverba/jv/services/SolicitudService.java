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
        int n = 0;

        try {
            if (!solicitudRepository.existsByEmail(solicitud.getEmail())) {
                solicitud.setId(null == solicitudRepository.findMaxId()? 0 : solicitudRepository.findMaxId() + 1);
                solicitud.setHora(DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalDateTime.now()));
                solicitud.setFecha(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now()));
                solicitud.setCode(com.jaeverba.jv.utils.Random.password(20));
                solicitudRepository.save(solicitud);
                n = 1;
            }
        } catch (Exception e) {
            throw e;
        }

        return n;
    }

    @Transactional
    public boolean delete(String email) {
        boolean borrado = false;

        try {
            solicitudRepository.deleteByEmail(email);
            borrado = true;
        } catch (Exception e) {
            throw e;
        }

        return borrado;
    }

    public List<Solicitud> getAll() {
        return solicitudRepository.findAll();
    }
}
