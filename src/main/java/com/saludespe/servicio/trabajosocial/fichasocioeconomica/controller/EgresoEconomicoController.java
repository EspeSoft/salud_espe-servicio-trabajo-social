package com.saludespe.servicio.trabajosocial.fichasocioeconomica.controller;


import com.saludespe.servicio.trabajosocial.fichasocioeconomica.model.EgresoEconomico;
import com.saludespe.servicio.trabajosocial.fichasocioeconomica.model.FichaSocioeconomica;
import com.saludespe.servicio.trabajosocial.fichasocioeconomica.service.interfaces.IEgresoEconomicoService;
import com.saludespe.servicio.trabajosocial.fichasocioeconomica.service.interfaces.IFichaSocioeconomicaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RequestMapping(value="{idPaciente}/egresos-economicos")
@Validated
@RestController
public class EgresoEconomicoController {
    private static String egresoNotFoundMessage = "No existe egreso económico para el paciente: ";

    @Autowired
    private IEgresoEconomicoService service;

    @Autowired
    private IFichaSocioeconomicaService fichaSocioeconomicaService;

    @PostMapping("/")
    @ApiOperation(
            value = "Ingresar egreso económico",
            notes = "Se debe enviar el body en formato Json",
            response = EgresoEconomico.class)
    public EgresoEconomico save(@PathVariable Long idPaciente,
                              @Valid @RequestBody EgresoEconomico egresoEconomico) {
        Optional<FichaSocioeconomica> fichaSocioeconomica = fichaSocioeconomicaService.findByPaciente(idPaciente);
        if (fichaSocioeconomica.isPresent()){
            egresoEconomico.setFichaSocioeconomica(fichaSocioeconomica.get());
            return  service.save(egresoEconomico);
        }else  {
            throw new EntityNotFoundException(egresoNotFoundMessage + idPaciente);
        }

    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar egreso económico por id",
            notes = "Se debe enviar el id",
            response = EgresoEconomico.class)
    public EgresoEconomico retrieve(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar egreso económico por id",
            notes = "Se debe enviar el id",
            response = EgresoEconomico.class)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @DeleteMapping("/delete-all")
    @ApiOperation(
            value = "Eliminar una lista de egresos económicos",
            notes = "Se debe enviar una lista",
            response = EgresoEconomico.class)
    public void deleteAll(@RequestBody List<EgresoEconomico> egresoEconomicoList) {
        service.deleteAll(egresoEconomicoList);
    }

    @GetMapping("")
    @ApiOperation(
            value = "Buscar lista de egresos económicos por paciente", notes = "", response = EgresoEconomico.class)
    public List<EgresoEconomico> egresoEconomicoList(@PathVariable Long idPaciente) {
        Optional<FichaSocioeconomica> fichaSocioeconomica = fichaSocioeconomicaService.findByPaciente(idPaciente);
        if(fichaSocioeconomica.isPresent()){
            return service.findByFichaSocioeconomica(fichaSocioeconomica.get().getId());
        }else {
            throw new EntityNotFoundException(egresoNotFoundMessage + idPaciente);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(
            value = "Actualizar egreso económico por id",
            notes = "Se debe enviar el body y el id a actualizar",
            response = EgresoEconomico.class)
    public EgresoEconomico update(
            @PathVariable Long idPaciente,
            @Valid @RequestBody EgresoEconomico egresoEconomico, @PathVariable Long id){
        Optional<FichaSocioeconomica> fichaSocioeconomica = fichaSocioeconomicaService.findByPaciente(idPaciente);
        if (fichaSocioeconomica.isPresent()){
            EgresoEconomico egreso = service.findById(id);
            egreso.setTipoEgreso(egresoEconomico.getTipoEgreso());
            egreso.setValorEgreso(egreso.getValorEgreso());
            return service.save(egreso);
        }else{
            throw new EntityNotFoundException(egresoNotFoundMessage + idPaciente);
        }
    }

}