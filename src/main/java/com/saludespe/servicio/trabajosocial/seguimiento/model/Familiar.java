package com.saludespe.servicio.trabajosocial.seguimiento.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Familiar {

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "parentezco")
    private String parentezco;
}
