package com.saludespe.trabajosocial.controller;

import com.saludespe.trabajosocial.model.entities.FichaSocioeconomica;
import com.saludespe.trabajosocial.model.services.interfaces.IFichaSocioeconomicaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RequestMapping(value="/ficha-socioeconomica")
@Validated
@RestController
public class FichaSocioeconomicaController {

    @Autowired
    private IFichaSocioeconomicaService service;

    @PostMapping("")
    @ApiOperation(value = "Ingresar ficha socioeconomica", notes = "Se debe enviar el body en formato Json", response = FichaSocioeconomica.class)
    public FichaSocioeconomica save(@Valid @RequestBody FichaSocioeconomica fichaSocioeconomica) {
        FichaSocioeconomica fichaSocioeconomica1 = service.findByPaciente(fichaSocioeconomica.getIdPaciente());
        if (fichaSocioeconomica1 == null) {
            return service.save(fichaSocioeconomica);
        }else {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "El paciente ya posee una ficha socioeconómica.");
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar ficha socioeconomica por id", notes = "Se debe enviar el id", response = FichaSocioeconomica.class)
    public FichaSocioeconomica retrieve(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/search/findByPaciente")
    @ApiOperation(value = "Buscar ficha socioeconómica por Id del paciente", notes = "", response = FichaSocioeconomica.class)
    public FichaSocioeconomica findByPaciente(@RequestParam Long idPaciente) {
        return service.findByPaciente(idPaciente);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualizar ficha socioeconómica por id", notes = "Se debe enviar el body y el id a actualizar", response = FichaSocioeconomica.class)
    public FichaSocioeconomica update(@Valid @RequestBody FichaSocioeconomica fichaSocioeconomica, @PathVariable Long id){
        FichaSocioeconomica fichaSocioeconomica1 = service.findById(id);
        fichaSocioeconomica1=fichaSocioeconomica;
        return (service.save(fichaSocioeconomica1));
    }

}
