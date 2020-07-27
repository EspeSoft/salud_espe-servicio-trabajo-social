package com.saludespe.servicio.trabajosocial.controller;


import com.saludespe.servicio.trabajosocial.model.FichaSocioeconomica;
import com.saludespe.servicio.trabajosocial.model.IngresoEconomico;
import com.saludespe.servicio.trabajosocial.service.interfaces.IFichaSocioeconomicaService;
import com.saludespe.servicio.trabajosocial.service.interfaces.IIngresoEconomicoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RequestMapping(value="{idPaciente}/ingresos-economicos")
@Validated
@RestController
public class IngresoEconomicoController {

    private static String ingresoNotFoundMessage = "No existe ingresos económicos, para el paciente: ";

    @Autowired
    private IIngresoEconomicoService service;

    @Autowired
    private IFichaSocioeconomicaService fichaSocioeconomicaService;

    @PostMapping("/")
    @ApiOperation(
            value = "Ingresar ingreso económico",
            notes = "Se debe enviar el body en formato Json",
            response = IngresoEconomico.class)
    public IngresoEconomico save(@PathVariable Long idPaciente,
                                 @Valid @RequestBody IngresoEconomico ingresoEconomico) {
        Optional<FichaSocioeconomica> fichaSocioeconomica = fichaSocioeconomicaService.findByPaciente(idPaciente);
        if (fichaSocioeconomica.isPresent()){
            ingresoEconomico.setFichaSocioeconomica(fichaSocioeconomica.get());
            return  service.save(ingresoEconomico);
        }else  {
            throw new EntityNotFoundException(ingresoNotFoundMessage + idPaciente);
        }
    }


    @GetMapping("/{id}")
    @ApiOperation(
            value = "Buscar ingreso económico por id",
            notes = "Se debe enviar el id",
            response = IngresoEconomico.class)
    public IngresoEconomico retrieve(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar ingreso económico por id", notes = "Se debe enviar el id", response = IngresoEconomico.class)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @DeleteMapping("/delete-all")
    @ApiOperation(
            value = "Eliminar una lista de ingresos económicos",
            notes = "Se debe enviar una lista",
            response = IngresoEconomico.class)
    public void deleteAll(@RequestBody List<IngresoEconomico> ingresoEconomicoList) {
        service.deleteAll(ingresoEconomicoList);
    }


    @GetMapping("")
    @ApiOperation(
            value = "Buscar lista de ingreso económico paciente",
            notes = "", response = IngresoEconomico.class)
    public List<IngresoEconomico> listByAntecedentePersonal(@PathVariable Long idPaciente) {
        Optional<FichaSocioeconomica> fichaSocioeconomica = fichaSocioeconomicaService.findByPaciente(idPaciente);
        if(fichaSocioeconomica.isPresent()){
            return service.findByFichaSocioeconomica(fichaSocioeconomica.get().getId());
        }else {
            throw new EntityNotFoundException(ingresoNotFoundMessage + idPaciente);
        }
    }


    @PutMapping("/{id}")
    @ApiOperation(
            value = "Actualizar ingreso económico por id",
            notes = "Se debe enviar el body y el id a actualizar",
            response = IngresoEconomico.class)
    public IngresoEconomico update(
            @PathVariable Long idPaciente,
            @Valid @RequestBody IngresoEconomico ingresoEconomico, @PathVariable Long id){
        Optional<FichaSocioeconomica> fichaSocioeconomica = fichaSocioeconomicaService.findByPaciente(idPaciente);
        if (fichaSocioeconomica.isPresent()){
            IngresoEconomico ingreso = service.findById(id);
           ingreso.setTipoIngreso(ingresoEconomico.getTipoIngreso());
           ingreso.setValorIngreso(ingresoEconomico.getValorIngreso());
            return service.save(ingreso);
        }else{
            throw new EntityNotFoundException(ingresoNotFoundMessage + idPaciente);
        }
    }

}
