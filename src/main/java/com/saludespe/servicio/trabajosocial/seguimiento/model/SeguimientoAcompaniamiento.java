package com.saludespe.servicio.trabajosocial.seguimiento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Data
@Table(name = "SEGUIMIENTOS_ACOMPANIAMIENTOS")
public class SeguimientoAcompaniamiento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "fecha") 
    private LocalDate fecha;

    @NotNull
    @Column(name = "descripcion") // TODO Implementar como campo unico
    private Long descripcion;

    @NotNull
    @Column(name = "observacion") // TODO Implementar como campo unico
    private Long observacion;

    @JoinColumn(name = "id_seguimiento", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private Seguimiento seguimiento;


}
