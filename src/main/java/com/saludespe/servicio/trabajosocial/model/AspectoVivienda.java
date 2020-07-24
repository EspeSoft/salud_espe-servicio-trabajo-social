package com.saludespe.servicio.trabajosocial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ASPECTOS_VIVIENDA")
public class AspectoVivienda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(name = "tenencia")
    private String tenencia;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "estructura")
    private String estructura;

    @Column(name = "tiene_agua_potable")
    private Boolean tieneAguaPotable;

    @Column(name = "tienen_luz_electrica")
    private Boolean tieneLuzElectrica;

    @Column(name = "tiene_alcantarillado")
    private Boolean tieneAlcantarillado;

    @Column(name = "tiene_telefono")
    private Boolean tieneTelefono;

    @OneToOne(mappedBy = "aspectoVivienda")
    @JsonIgnore
    private FichaSocioeconomica fichaSocioeconomica;

}
