package com.saludespe.servicio.trabajosocial.fichasocioeconomica.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@Table(name = "FICHAS_SOCIOECONOMICAS")
public class FichaSocioeconomica implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha")
    private LocalDate fechaRegistro;

    @Column(name = "genograma")
    private String genograma;

    @Column(name = "dinamica_familiar")
    private String dinamicaFamiliar;

    @Embedded
    private AspectoVivienda aspectoVivienda;

    @NotNull
	@Column(name = "id_paciente") // TODO Implementar como campo unico
    private Long idPaciente;

    @OneToMany(mappedBy = "fichaSocioeconomica", fetch = FetchType.LAZY)
    private List<IngresoEconomico> ingresoEconomicoList;

    @OneToMany(mappedBy ="fichaSocioeconomica", fetch = FetchType.LAZY)
    private List<EgresoEconomico> egresoEconomicoList;

    @OneToMany(mappedBy = "fichaSocioeconomica", fetch = FetchType.LAZY)
    private List<GrupoFamiliar> familiarList;

    @OneToMany(mappedBy = "fichaSocioeconomica", fetch = FetchType.LAZY)
    private List<AspectoSocial> aspectoSocialList;

    @OneToMany(mappedBy = "fichaSocioeconomica", fetch = FetchType.LAZY)
    private List<ProblemaDetectado> problemasDetectados;

    @PrePersist
    void preInsert(){
        if(this.fechaRegistro == null){
            this.fechaRegistro = LocalDate.now();
        }
    }
}