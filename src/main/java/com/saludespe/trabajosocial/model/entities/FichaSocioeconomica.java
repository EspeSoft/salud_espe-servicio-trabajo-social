package com.saludespe.trabajosocial.model.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import javax.persistence.OneToMany;

@Entity
@Data
@Table(name = "FICHA_SOCIOECONOMICA")
public class FichaSocioeconomica implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Size(max = 300, message = "{size.fichasocioecomica.genograma}")
    @Column(name = "genograma")
    private String genograma;

    @Size(max = 200, message = "{size.fichasocioeconomica.dinamicaFamiliar}")
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
    private List<Familiar> familiarList;

    @OneToMany(mappedBy = "necesidadCapacitacionSocial", fetch = FetchType.LAZY)
    private List<NecesidadCapacitacionSocial> necesidadCapacitacionSocialList;

    @OneToMany(mappedBy = "problema", fetch = FetchType.LAZY)
    private List<Problema> problemaList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_aspecto_vivienda", referencedColumnName ="id" )
    private AspectoVivienda aspectoVivienda;


}