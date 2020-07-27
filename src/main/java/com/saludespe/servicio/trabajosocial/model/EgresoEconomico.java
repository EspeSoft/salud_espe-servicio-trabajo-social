package com.saludespe.servicio.trabajosocial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Data
@Table(name = "EGRESOS_ECONOMICOS")
public class EgresoEconomico implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "id_ficha_socioeconomica", referencedColumnName = "id") // claves foraneas
    @ManyToOne
    @JsonIgnore
    private FichaSocioeconomica fichaSocioeconomica;

    @Column(name = "tipo_egreso")
    private String tipoEgreso;

    @Column(name = "valor_egreso")
    private Double valorEgreso;

}