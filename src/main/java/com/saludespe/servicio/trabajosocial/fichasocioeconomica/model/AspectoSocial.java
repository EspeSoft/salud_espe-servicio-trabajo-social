package com.saludespe.servicio.trabajosocial.fichasocioeconomica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
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

    @Column(name = "frecuencia")
    private String frecuencia;

    @Column(name = "observacion")
    private String observacion;

    @JoinColumn(name = "id_ficha_socioeconomica", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private FichaSocioeconomica fichaSocioeconomica;
}