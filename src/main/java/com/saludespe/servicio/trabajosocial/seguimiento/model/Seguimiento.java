package com.saludespe.servicio.trabajosocial.seguimiento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.saludespe.servicio.trabajosocial.fichasocioeconomica.model.IngresoEconomico;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "SEGUIMIENTOS")
public class Seguimiento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "id_paciente") // TODO Implementar como campo unico
    private Long idPaciente;

    @NotNull
    @Column(name = "id_evolucion") // TODO Implementar como campo unico
    private Long idEvolucion;

    @NotNull
    @Column(name = "fecha_inicio")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaInicio;

    @NotNull
    @Column(name = "estado") // TODO Implementar como campo unico
    private String descripcion;

    @OneToMany(mappedBy = "seguimiento", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Visita> visitaList;

    @OneToMany(mappedBy = "seguimiento", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<SeguimientoAcompaniamiento> seguimientoAcompaniamientoList;

    @PrePersist
    void preInsert(){
        if(this.fechaInicio == null){
            this.fechaInicio = LocalDate.now();
        }
    }
}
