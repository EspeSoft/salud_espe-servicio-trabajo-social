package com.saludespe.trabajosocial.controller;


import com.saludespe.trabajosocial.model.entities.Problema;
import com.saludespe.trabajosocial.model.services.interfaces.IFichaSocioeconomicaService;
import com.saludespe.trabajosocial.model.services.interfaces.IProblemaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequestMapping(value="/problema")
@Validated
@RestController
public class ProblemaController {

    @Autowired
    private IProblemaService service;


    @Autowired
    private IFichaSocioeconomicaService fichaSocioeconomicaService;

    @PostMapping("")
    @ApiOperation(value = "Ingresar problema", notes = "Se debe enviar el body en formato Json", response = Problema.class)
    public Problema save(@PathVariable Long idPaciente, @Valid @RequestBody Problema problema) {
        problema.setFichaSocioeconomica(fichaSocioeconomicaService.findByPaciente(idPaciente));
        return service.save(problema);
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar problema por id", notes = "Se debe enviar el id", response = Problema.class)
    public Problema retrieve(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar problema por id", notes = "Se debe enviar el id", response = Problema.class)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("")
    @ApiOperation(value = "Buscar lista de problemas de paciente", notes = "", response = Problema.class)
    public List<Problema> listByAntecedentePersonal(@PathVariable Long idPaciente) {
        return service.findByFichaSocioeconomica((fichaSocioeconomicaService.findByPaciente(idPaciente)).getId());
    }

    @GetMapping("/all")
    @ApiOperation(value = "Buscar lista de problemas", notes = "", response = Problema.class)
    public List<Problema> list() {
        return service.findAll();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualizar problema por id", notes = "Se debe enviar el body y el id a actualizar", response = Problema.class)
    public Problema update(@PathVariable Long idPaciente, @Valid @RequestBody Problema problema, @PathVariable Long id){
        problema.setFichaSocioeconomica(fichaSocioeconomicaService.findByPaciente(idPaciente));
        Problema problema1 = service.findById(id);
        problema1=problema;
        return (service.save(problema1));
    }
}
