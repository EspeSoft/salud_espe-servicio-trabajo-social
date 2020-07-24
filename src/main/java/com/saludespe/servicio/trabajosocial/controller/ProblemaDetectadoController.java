package com.saludespe.servicio.trabajosocial.controller;

import com.saludespe.servicio.trabajosocial.model.FichaSocioeconomica;
import com.saludespe.servicio.trabajosocial.model.ProblemaDetectado;
import com.saludespe.servicio.trabajosocial.service.interfaces.IFichaSocioeconomicaService;
import com.saludespe.servicio.trabajosocial.service.interfaces.IProblemaDetectadoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RequestMapping(value="{idPaciente}/problemas-detectados")
@Validated
@RestController
public class ProblemaDetectadoController {

    private static String problemaNotFoundMessage = "No existe un registro de este tipo, para el paciente: ";

    @Autowired
    private IProblemaDetectadoService service;


    @Autowired
    private IFichaSocioeconomicaService fichaSocioeconomicaService;

    @PostMapping("")
    @ApiOperation(
            value = "Ingresar problema",
            notes = "Se debe enviar el body en formato Json",
            response = ProblemaDetectado.class)
    public ProblemaDetectado save(@PathVariable Long idPaciente,
                                  @Valid @RequestBody ProblemaDetectado problemaDetectado) {
        Optional<FichaSocioeconomica> fichaSocioeconomica = fichaSocioeconomicaService.findByPaciente(idPaciente);
        if (fichaSocioeconomica.isPresent()){
            problemaDetectado.setFichaSocioeconomica(fichaSocioeconomica.get());
            return  service.save(problemaDetectado);
        }else  {
            throw new EntityNotFoundException(problemaNotFoundMessage + idPaciente);
        }
    }


    @GetMapping("/{id}")
    @ApiOperation(
            value = "Buscar problema por id",
            notes = "Se debe enviar el id",
            response = ProblemaDetectado.class)
    public ProblemaDetectado retrieve(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar problema por id", notes = "Se debe enviar el id", response = ProblemaDetectado.class)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @DeleteMapping("/delete-all")
    @ApiOperation(
            value = "Eliminar una lista de aspectos sociales",
            notes = "Se debe enviar una lista",
            response = ProblemaDetectado.class)
    public void deleteAll(@RequestBody List<ProblemaDetectado> problemaDetectadoList) {
        service.deleteAll(problemaDetectadoList);
    }


    @GetMapping("")
    @ApiOperation(
            value = "Buscar lista de problemas de paciente",
            notes = "", response = ProblemaDetectado.class)
    public List<ProblemaDetectado> listByAntecedentePersonal(@PathVariable Long idPaciente) {
        Optional<FichaSocioeconomica> fichaSocioeconomica = fichaSocioeconomicaService.findByPaciente(idPaciente);
        if(fichaSocioeconomica.isPresent()){
            return service.findByFichaSocioeconomica(fichaSocioeconomica.get().getId());
        }else {
            throw new EntityNotFoundException(problemaNotFoundMessage + idPaciente);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(
            value = "Actualizar problema detectado por id",
            notes = "Se debe enviar el body y el id a actualizar",
            response = ProblemaDetectado.class)
    public ProblemaDetectado update(
            @PathVariable Long idPaciente,
            @Valid @RequestBody ProblemaDetectado problemaDetectado, @PathVariable Long id){
        Optional<FichaSocioeconomica> fichaSocioeconomica = fichaSocioeconomicaService.findByPaciente(idPaciente);
        if (fichaSocioeconomica.isPresent()){
            ProblemaDetectado problema = service.findById(id);
            problema.setDetalle(problemaDetectado.getDetalle());
            problema.setObservacion(problemaDetectado.getObservacion());
            return service.save(problema);
        }else{
            throw new EntityNotFoundException(problemaNotFoundMessage + idPaciente);
        }
    }
}
