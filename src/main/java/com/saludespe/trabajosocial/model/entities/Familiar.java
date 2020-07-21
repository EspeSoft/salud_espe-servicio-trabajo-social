package com.saludespe.trabajosocial.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Data
@Table(name = "FAMILIAR")
public class Familiar  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @JoinColumn(name = "id_ficha_socioeconomica", referencedColumnName = "id") // claves foraneas
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private FichaSocioeconomica fichaSocioeconomica;

    @Size(max = 300, message = "{size.trabajosocial.300}")
    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @Column(name = "edad")
    private Integer edad;

    @Size(max = 200, message = "{size.trabajosocial.200}")
    @Column(name = "parentesco")
    private String parentesco;

    @Size(max = 300, message = "{size.trabajosocial.300}")
    @Column(name = "estudio_realizado")
    private String estudioRealizado;

    @Size(max = 200, message = "{size.trabajosocial.200}")
    @Column(name = "estado_civil")
    private String estado_civil;

    @Size(max = 300, message = "{size.trabajosocial.300}")
    @Column(name = "vinculacion_laboral")
    private String vinculacionLaboral;

    @Size(max = 300, message = "{size.trabajosocial.300}")
    @Column(name = "estado_salud")
    private String estadoSalud;

}
