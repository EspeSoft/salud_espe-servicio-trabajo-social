package com.saludespe.trabajosocial.model.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import javax.persistence.OneToMany;

@Entity
@Data
@Table(name = "FICHAS_SOCIOECONOMICAS")
public class FichaSocioeconomica implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
    @Column(name = "id")
    private Long id;


    @Column(name = "genograma")
    private String genograma;


    @Column(name = "dinamica_familiar")
    private String dinamicaFamiliar;

    @NotNull
	@Column(name = "id_paciente")
    private Long idPaciente;

    @OneToMany(mappedBy = "ingresoEconomico", fetch = FetchType.LAZY)
    private List<IngresoEconomico> ingresoEconomicoList;

    @OneToMany(mappedBy ="egresoEconomico", fetch = FetchType.LAZY)
    private List<EgresoEconomico> egresoEconomicoList;

    @OneToMany(mappedBy = "familiar", fetch = FetchType.LAZY)
    private List<GrupoFamiliar> familiarList;

    @OneToMany(mappedBy = "necesidadCapacitacionSocial", fetch = FetchType.LAZY)
    private List<AspectoSocial> aspectoSocialList;

    @OneToMany(mappedBy = "problema", fetch = FetchType.LAZY)
    private List<ProblemaDetectado> problemaDetectadoList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_aspecto_vivienda", referencedColumnName ="id" )
    private AspectoVivienda aspectoVivienda;


}