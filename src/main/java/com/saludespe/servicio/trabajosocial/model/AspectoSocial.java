package com.saludespe.servicio.trabajosocial.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "ASPECTOS_SOCIALES")
public class AspectoSocial implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre_necesidad")
    private String nombreNecesidad;

    @Column(name = "observacion")
    private String observacion;

    @JoinColumn(name = "id_ficha_socioeconomica", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private FichaSocioeconomica fichaSocioeconomica;
}