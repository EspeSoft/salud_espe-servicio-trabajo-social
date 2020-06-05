package com.saludespe.trabajosocial.model.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Data
@Table(name = "FICHA_SOCIOECONOMICA")
public class FichaSocioeconomica implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
    @Column(name = "id_ficha_socieconomica")
    private Long idFichaSocioeconomica;

    @Size(max = 300, message = "{Size.fichasocioeconomica.genograma}")
    @Column(name = "genograma")
    private String genograma;


    @Size(max = 200, message = "{Size.fichasocioeconomica.dinamicaFamiliar}")
    @Column(name = "dinamica_familiar")
    private String dinamicaFamiliar;

    @NotNull
	@Column(name = "id_empleado")
    private Long idEmpleado;

}