package com.jaeverba.jv.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@ToString
public class Solicitud {

    @Id
    @Getter @Setter
    private int id;

    @Getter @Setter
    private String mensaje;

    @Getter @Setter
    private String nombres;

    @Getter @Setter
    @Column(unique = true)
    private String email;

    @Getter @Setter
    private boolean aprobado;

    @Getter @Setter
    private String fecha;

    @Getter @Setter
    private String hora;

    @Getter @Setter
    @Column(unique = true, length = 20)
    private String code;

    public Solicitud() {}
}
