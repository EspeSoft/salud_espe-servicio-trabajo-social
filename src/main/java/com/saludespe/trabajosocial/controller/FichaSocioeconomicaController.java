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

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Buscar una Ficha Socioeconómica por su Id",
            notes = "Debe proporcionar un id para buscar un Ficha Socioeconómica", response = FichaSocioeconomica.class)
    public FichaSocioeconomica retrieve(@PathVariable(value = "id") Long id) {
        try {
            return service.findById(id);
        } catch (NoSuchElementException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Ficha socioeconomica no encontrado", ex);
        }
    }

    @GetMapping("/all")
    @ApiOperation(value = "Buscar lista de FichaSocioeconomica", notes = "", response = FichaSocioeconomica.class)
    public List<FichaSocioeconomica> list() {
        return service.findAll();
    }

    @PostMapping("")
    @ApiOperation(value = "Guardar la lista de Fichas Socioeconomicas", notes = "Se guardará los datos de signos vitales", response = FichaSocioeconomica.class)
    public FichaSocioeconomica save(@Valid @RequestBody FichaSocioeconomica fichaSocioeconomica) {
        return service.save(fichaSocioeconomica);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar la lista de Fichas Socioeconomicas", notes = "Debe proporcionar un id para eliminar un Signo Vital", response = FichaSocioeconomica.class)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualizar fichaSocioeconomica por id", notes = "Se debe enviar el body y el id a actualizar", response = FichaSocioeconomica.class)
    public FichaSocioeconomica update(@PathVariable Long idPaciente, @Valid @RequestBody FichaSocioeconomica fichaSocioeconomica, @PathVariable Long id){
        FichaSocioeconomica newFichaSocioeconomica = service.findById(id);
        newFichaSocioeconomica=fichaSocioeconomica;
        return (service.save(newFichaSocioeconomica));
    }


}
