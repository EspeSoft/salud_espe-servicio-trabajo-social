package com.saludespe.trabajosocial.model.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ASPECTOS_IMPORTANTES")
public class AspectosImportantes implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "descipcion")
    private String descripcion;




}