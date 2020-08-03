package com.saludespe.servicio.trabajosocial.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Embeddable
public class AspectoVivienda {

    @Column(name = "tenencia")
    private String tenencia;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "estructura")
    private String estructura;

    @Column(name = "tiene_agua_potable")
    private Boolean tieneAguaPotable;

    @Column(name = "tienen_luz_electrica")
    private Boolean tieneLuzElectrica;

    @Column(name = "tiene_alcantarillado")
    private Boolean tieneAlcantarillado;

    @Column(name = "tiene_telefono")
    private Boolean tieneTelefono;

}
