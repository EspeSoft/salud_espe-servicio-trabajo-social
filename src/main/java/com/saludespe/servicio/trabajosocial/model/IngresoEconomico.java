package com.saludespe.servicio.trabajosocial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@Table(name = "INGRESOS_ECONOMICOS")
public class IngresoEconomico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @JoinColumn(name = "id_ficha_socioeconomica", referencedColumnName = "id") // claves foraneas
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private FichaSocioeconomica fichaSocioeconomica;

    @Column(name = "tipo_ingreso")
    private String tipoIngreso;

    @Column(name = "valor_ingreso")
    private Double valorIngreso;

}
