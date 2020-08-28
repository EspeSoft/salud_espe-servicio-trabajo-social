package com.saludespe.servicio.trabajosocial.fichasocioeconomica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "PROBLEMAS_DETECTADOS")
public class ProblemaDetectado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(name = "detalle")
    private String detalle;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "observacion")
    private String observacion;

    @JoinColumn(name = "id_ficha_socioeconomica", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private FichaSocioeconomica fichaSocioeconomica;

    @PrePersist
    void preInsert(){
        if(this.fecha == null){
            this.fecha = LocalDate.now();
        }
    }

}
