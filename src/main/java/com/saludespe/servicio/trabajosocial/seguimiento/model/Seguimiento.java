package com.saludespe.servicio.trabajosocial.seguimiento.model;

import com.saludespe.servicio.trabajosocial.fichasocioeconomica.model.IngresoEconomico;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
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

    @OneToMany(mappedBy = "seguimiento", fetch = FetchType.LAZY)
    private List<Visita> visitaList;

}
