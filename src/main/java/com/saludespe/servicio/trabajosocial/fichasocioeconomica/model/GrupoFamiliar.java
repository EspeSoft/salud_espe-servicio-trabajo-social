package com.saludespe.servicio.trabajosocial.fichasocioeconomica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "GRUPOS_FAMILIARES")
public class GrupoFamiliar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @JoinColumn(name = "id_ficha_socioeconomica", referencedColumnName = "id") // claves foraneas
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private FichaSocioeconomica fichaSocioeconomica;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "parentesco")
    private String parentesco;

    @Column(name = "estudio_realizado")
    private String estudioRealizado;

    @Column(name = "estado_civil")
    private String estadoCivil;

    @Column(name = "vinculacion_laboral")
    private String vinculacionLaboral;

    @Column(name = "estado_salud")
    private String estadoSalud;

}
