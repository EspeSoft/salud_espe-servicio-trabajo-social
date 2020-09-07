package com.saludespe.servicio.trabajosocial.fichasocioeconomica.controller;

import com.saludespe.servicio.trabajosocial.fichasocioeconomica.model.FichaSocioeconomica;
import com.saludespe.servicio.trabajosocial.fichasocioeconomica.service.interfaces.IFichaSocioeconomicaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Optional;

@Validated
@RestController
@RequestMapping(value="/fichas-socioeconomicas")
public class FichaSocioeconomicaController {

    private static String notFoundMessage = "Ficha socioeconómica no encontrado para el id: ";

    @Autowired
    private IFichaSocioeconomicaService service;

    @PostMapping("/")
    @ApiOperation(
            value = "Ingresar ficha socioeconomica",
            notes = "Se debe enviar el body en formato Json",
            response = FichaSocioeconomica.class)
    public FichaSocioeconomica save(@Valid @RequestBody FichaSocioeconomica fichaSocioeconomica) {
        Optional<FichaSocioeconomica> fichaSocioeconomica1 = service.findByPaciente(fichaSocioeconomica.getIdPaciente());
        if (!fichaSocioeconomica1.isPresent()) {
            return service.save(fichaSocioeconomica);
        }else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "El paciente ya posee una ficha socioeconómica.");
        }
    }

    @GetMapping(
            value = "/{id}",
            produces = "application/json")
    @ApiOperation(
            value = "Buscar ficha socioeconomica por id",
            notes = "Se debe enviar el id",
            response = FichaSocioeconomica.class)
    public FichaSocioeconomica retrieve(@PathVariable Long id) {
        Optional<FichaSocioeconomica> fichaSocioeconomica = service.findById(id);
        if (fichaSocioeconomica.isPresent()){
            return fichaSocioeconomica.get();
        }else{
            throw new EntityNotFoundException(notFoundMessage + id);
        }
    }

    @GetMapping("/search")
    @ApiOperation(
            value = "Buscar ficha socioeconómica por Id del paciente",
            notes = "Enviar id del paciente",
            response = FichaSocioeconomica.class)
    public FichaSocioeconomica findByPaciente(@RequestParam Long idPaciente) {
        Optional<FichaSocioeconomica> fichaSocioeconomica = service.findByPaciente(idPaciente);
        if (fichaSocioeconomica.isPresent()){
            return fichaSocioeconomica.get();
        }else{
            throw new EntityNotFoundException(notFoundMessage + idPaciente);
        }
    }
    @PutMapping("/{id}")
    @ApiOperation(
            value = "Actualizar ficha socioeconómica por id",
            notes = "Se debe enviar el body y el id a actualizar",
            response = FichaSocioeconomica.class)
    public FichaSocioeconomica update(@Valid @RequestBody FichaSocioeconomica fichaSocioeconomica, @PathVariable Long id){
        Optional<FichaSocioeconomica> optional = service.findById(id);
        if (optional.isPresent()){
           FichaSocioeconomica ficha = optional.get();
           ficha.setFechaRegistro(fichaSocioeconomica.getFechaRegistro());
           ficha.setDinamicaFamiliar(fichaSocioeconomica.getDinamicaFamiliar());
           ficha.setGenograma(fichaSocioeconomica.getGenograma());
           ficha.setAspectoVivienda(fichaSocioeconomica.getAspectoVivienda());
            return service.save(ficha);
        }else{
            throw new EntityNotFoundException(notFoundMessage + id);
        }
    }

}
