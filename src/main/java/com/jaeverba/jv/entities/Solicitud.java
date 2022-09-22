package com.jaeverba.jv.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

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
    private String email;

    @Getter @Setter
    private boolean aprobado;

    @Getter @Setter
    private String fecha;

    @Getter @Setter
    private String hora;

    public Solicitud() {}
}
