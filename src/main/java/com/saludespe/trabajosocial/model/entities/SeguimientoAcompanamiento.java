package com.saludespe.trabajosocial.model.entities;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import javax.persistence.ManyToOne;
@Entity
@Data
@Table(name = "SEGUIMIENTO_ACOMPANAMIENTO")
public class SeguimientoAcompanamiento implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "observacion")
    private String observacion;



}