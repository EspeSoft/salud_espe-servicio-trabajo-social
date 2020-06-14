package com.saludespe.trabajosocial.model.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "EGRESOECONOMICO")
public class EgresoEconomico implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(name = "egreso_vivienda")
    private float egresoVivienda;

    @Column(name = "egreso_alimentacion")
    private float egresoAlimentacion;


	@Column(name = "egreso_vestuario")
    private float egresoVestuario;

    @Column(name = "egreso_educacion")
    private float egresoEducacion;

    @Column(name = "egreso_salud")
    private float egresoSalud;

    @Column(name = "egreso_PensionJudicial")
    private float egresoPensionJudicial;

    @Column(name = "egreso_otros")
    private float egresoOtros;

    @NotNull
	@Column(name = "id_ficha_socieconomica")
    private Long idFichaSocioeconomica;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getEgresoVivienda() {
        return egresoVivienda;
    }

    public void setEgresoVivienda(float egresoVivienda) {
        this.egresoVivienda = egresoVivienda;
    }

    public float getEgresoAlimentacion() {
        return egresoAlimentacion;
    }

    public void setEgresoAlimentacion(float egresoAlimentacion) {
        this.egresoAlimentacion = egresoAlimentacion;
    }

    public float getEgresoVestuario() {
        return egresoVestuario;
    }

    public void setEgresoVestuario(float egresoVestuario) {
        this.egresoVestuario = egresoVestuario;
    }

    public float getEgresoEducacion() {
        return egresoEducacion;
    }

    public void setEgresoEducacion(float egresoEducacion) {
        this.egresoEducacion = egresoEducacion;
    }

    public float getEgresoSalud() {
        return egresoSalud;
    }

    public void setEgresoSalud(float egresoSalud) {
        this.egresoSalud = egresoSalud;
    }

    public float getEgresoPensionJudicial() {
        return egresoPensionJudicial;
    }

    public void setEgresoPensionJudicial(float egresoPensionJudicial) {
        this.egresoPensionJudicial = egresoPensionJudicial;
    }

    public float getEgresoOtros() {
        return egresoOtros;
    }

    public void setEgresoOtros(float egresoOtros) {
        this.egresoOtros = egresoOtros;
    }

    public Long getIdFichaSocioeconomica() {
        return idFichaSocioeconomica;
    }

    public void setIdFichaSocioeconomica(Long idFichaSocioeconomica) {
        this.idFichaSocioeconomica = idFichaSocioeconomica;
    }

    

}