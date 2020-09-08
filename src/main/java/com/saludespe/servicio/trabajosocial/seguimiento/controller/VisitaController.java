package com.saludespe.servicio.trabajosocial.seguimiento.controller;

import com.saludespe.servicio.trabajosocial.seguimiento.model.Seguimiento;
import com.saludespe.servicio.trabajosocial.seguimiento.model.Visita;
import com.saludespe.servicio.trabajosocial.seguimiento.service.interfaces.ISeguimientoService;
import com.saludespe.servicio.trabajosocial.seguimiento.service.interfaces.IVisitaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequestMapping(value="/seguimientos/{idSeguimiento}/visitas")
public class VisitaController {

    @Autowired
    private IVisitaService service;

    @Autowired
    private ISeguimientoService seguimientoService;


    @Autowired
    public VisitaController(
            IVisitaService service,
            ISeguimientoService seguimientoService) {
        this.service = service;
        this.seguimientoService = seguimientoService;
    }

    @PostMapping("/")
    @ApiOperation(
            value = "Ingresar visita",
            notes = "Se debe enviar el body en formato Json",
            response = Visita.class)
    public Visita save(@PathVariable Long idSeguimiento,
                              @Valid @RequestBody Visita visita) {
       Seguimiento seguimiento = seguimientoService.findById(idSeguimiento);
       visita.setSeguimiento(seguimiento);
       return service.save(visita);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar visita por id",
                    notes = "Se debe enviar el id",
                    response = Visita.class)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @DeleteMapping("/delete-all")
    @ApiOperation(
            value = "Eliminar una lista de visitas",
            notes = "Se debe enviar una lista",
            response = Visita.class)
    public void deleteAll(@RequestBody List<Visita> visitaList) {
        service.deleteAll(visitaList);
    }

    @GetMapping("")
    @ApiOperation(
            value = "Buscar lista de visitas por paciente", notes = "", response = Visita.class)
    public List<Visita> findBySeguimiento(@PathVariable Long idSeguimiento) {
        return service.findBySeguimiento(idSeguimiento);
    }


    @PutMapping("/{id}")
    @ApiOperation(
            value = "Actualizar visita por id",
            notes = "Se debe enviar el body y el id a actualizar",
            response = Visita.class)
    public Visita update(
            @Valid @RequestBody Visita visita, @PathVariable Long id){
            Visita visita1 = service.findById(id);
            visita1.setMotivo(visita.getMotivo());
            visita1.setFechaVisita(visita.getFechaVisita());
            visita1.setDireccionVisita(visita.getDireccionVisita());
            visita1.setHoraVisita(visita.getHoraVisita());
            visita1.setActividadesPorRealizar(visita.getActividadesPorRealizar());
            visita1.setEconomiaFamiliar(visita.getEconomiaFamiliar());
            visita1.setAsignacionHogar(visita.getAsignacionHogar());
            visita1.setEducacion(visita.getEducacion());
            visita1.setSalud(visita.getSalud());
            visita1.setFamilia(visita.getFamilia());
            visita1.setObservaciones(visita.getObservaciones());
            visita1.setHorasReposo(visita.getHorasReposo());
            visita1.setDiasReposo(visita.getDiasReposo());
            visita.setFamiliar(visita.getFamiliar());
            return service.save(visita1);
    }
}
