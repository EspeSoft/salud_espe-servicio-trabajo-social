package com.saludespe.trabajosocial.controller;


import com.saludespe.trabajosocial.model.entities.AspectoSocial;
import com.saludespe.trabajosocial.model.entities.FichaSocioeconomica;
import com.saludespe.trabajosocial.model.services.interfaces.IFichaSocioeconomicaService;
import com.saludespe.trabajosocial.model.services.interfaces.IAspectoSocialService;
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
@RequestMapping(value="{idPaciente}/aspectos-sociales")
public class AspectoSocialController {

    private static String aspectoNotFoundMessage = "No existe un registro  para el paciente: ";

    @Autowired
    private IAspectoSocialService service;

    @Autowired
    private IFichaSocioeconomicaService fichaSocioeconomicaService;

    @PostMapping("/")
    @ApiOperation(
            value = "Ingresar aspecto social",
            notes = "Se debe enviar el body en formato Json",
            response = AspectoSocial.class)
    public AspectoSocial save(@PathVariable Long idPaciente,
                              @Valid @RequestBody AspectoSocial aspectoSocial) {
        Optional<FichaSocioeconomica> fichaSocioeconomica = fichaSocioeconomicaService.findByPaciente(idPaciente);
        if (fichaSocioeconomica.isPresent()){
            aspectoSocial.setFichaSocioeconomica(fichaSocioeconomica.get());
            return  service.save(aspectoSocial);
        }else  {
            throw new EntityNotFoundException(aspectoNotFoundMessage + idPaciente);
        }

    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar aspecto social por id",
            notes = "Se debe enviar el id",
            response = AspectoSocial.class)
    public AspectoSocial retrieve(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar aspecto social por id", notes = "Se debe enviar el id", response = AspectoSocial.class)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @DeleteMapping("/delete-all")
    @ApiOperation(
            value = "Eliminar una lista de aspectos sociales",
            notes = "Se debe enviar una lista",
            response = AspectoSocial.class)
    public void deleteAll(@RequestBody List<AspectoSocial> aspectoSocials) {
        service.deleteAll(aspectoSocials);
    }

    @GetMapping("")
    @ApiOperation(
            value = "Buscar lista de aspecto social por paciente", notes = "", response = AspectoSocial.class)
    public List<AspectoSocial> aspectoSocialList(@PathVariable Long idPaciente) {
        Optional<FichaSocioeconomica> fichaSocioeconomica = fichaSocioeconomicaService.findByPaciente(idPaciente);
        if(fichaSocioeconomica.isPresent()){
            return service.findByFichaSocioeconomica(fichaSocioeconomica.get().getId());
        }else {
            throw new EntityNotFoundException(aspectoNotFoundMessage + idPaciente);
        }
    }


    @PutMapping("/{id}")
    @ApiOperation(
            value = "Actualizar aspecto social por id",
            notes = "Se debe enviar el body y el id a actualizar",
            response = AspectoSocial.class)
    public AspectoSocial update(
            @PathVariable Long idPaciente,
            @Valid @RequestBody AspectoSocial aspectoSocial, @PathVariable Long id){
        Optional<FichaSocioeconomica> fichaSocioeconomica = fichaSocioeconomicaService.findByPaciente(idPaciente);
        if (fichaSocioeconomica.isPresent()){
            AspectoSocial social = service.findById(id);
            social.setNombreNecesidad(aspectoSocial.getNombreNecesidad());
            social.setObservacion(aspectoSocial.getObservacion());
            return service.save(social);
        }else{
            throw new EntityNotFoundException(aspectoNotFoundMessage + idPaciente);
        }
    }

}
