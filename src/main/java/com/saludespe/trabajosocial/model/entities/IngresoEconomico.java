package com.saludespe.trabajosocial.model.entities;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.io.Serializable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@Data
@Table(name = "INGRESO_ECONOMICO")
public class IngresoEconomico implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

     @OneToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "id_ficha_socioeconomica",
             referencedColumnName = "id_ficha_socioeconomica")
     private FichaSocioeconomica fichaSocioeconomica;

    @Column(name = "ingreso_individual")
    @Digits(integer=10, fraction=2)
    private Float ingresoIndividual;

    @Column(name = "ingreso_conyuge")
    private Float ingresoConyuge;

    @Column(name = "ingreso_padres")
    private Float ingresoPadres;

    @Column(name = "ingreso_jubilacion")
    private Float ingresojubilacion;

    @Column(name = "ingreso_bono_estado")
    private Float ingresoBonoEstado;

    @Column(name = "ingreso_pension_judicial")
    private Float ingresoPensionJudicial;

    @Column(name = "ingreso_otros")
    private Float ingresoOtros;

}
