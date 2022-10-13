package com.jaeverba.jv.repositories;

import com.jaeverba.jv.entities.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {
    public boolean existsById(int id);
    public boolean existsByEmail(String email);

    public List<Solicitud> findById(int id);
    public List<Solicitud> findByEmail(String email);

    @Query("select max(s.id) from Solicitud s")
    public Integer findMaxId();
}
