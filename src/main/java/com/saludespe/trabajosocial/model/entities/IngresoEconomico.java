package com.saludespe.trabajosocial.model.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @JoinColumn(name = "id_ficha_socioeconomica", referencedColumnName = "id") // claves foraneas
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private FichaSocioeconomica fichaSocioeconomica;

    @Size(max = 200, message = "{size.ingresoEconomico.tipoIngreso}")
    @Column(name = "tipo_ingreso")
    private String tipoIngreso;

    @Column(name = "valor_ingreso")
    private Double valorIngreso;

}
