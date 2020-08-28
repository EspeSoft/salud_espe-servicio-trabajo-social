package com.saludespe.servicio.trabajosocial.seguimiento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.saludespe.servicio.trabajosocial.fichasocioeconomica.model.FichaSocioeconomica;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "VISITAS")
public class Visita {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "fecha_visita")
    private LocalDate fechaVisita;

    @Column(name = "direccion_visita")
    private String direccionVisita;

    @Column(name = "hora_visita")
    private LocalTime horaVisita;

    @Column(name = "actividades_por_realizar")
    private String actividadesPorRealizar;

    @Column(name = "economia_familiar")
    private String economiaFamiliar;

    @Column(name = "asignacion_hogar")
    private String asignacionHogar;

    @Column(name = "educacion")
    private String educacion;

    @Column(name = "salud")
    private String salud;

    @Column(name = "familia")
    private String familia;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "horas_reposo")
    private LocalTime horasReposo;

    @Column(name = "dias_reposo")
    private Integer diasReposo;

    @Embedded
    private Familiar familiar;

    @JoinColumn(name = "id_seguimiento", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private Seguimiento seguimiento;



}
