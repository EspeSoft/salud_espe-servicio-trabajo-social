package com.saludespe.trabajosocial.controller;

import com.saludespe.trabajosocial.model.entities.AspectoVivienda;
import com.saludespe.trabajosocial.model.entities.IngresoEconomico;
import com.saludespe.trabajosocial.model.services.interfaces.IAspectosViviendaService;
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

@RequestMapping(value="/aspectos-vivienda")
@Validated
@RestController
public class AspectoViviendaController {

    @Autowired
    private IAspectosViviendaService service;

    @Autowired
    private IFichaSocioeconomicaService fichaSocioeconomicaService;

    @PostMapping("")
    @ApiOperation(value = "Ingresar aspecto vivienda", notes = "Se debe enviar el body en formato Json", response = AspectoVivienda.class)
    public AspectoVivienda save(@PathVariable Long idPaciente, @Valid @RequestBody AspectoVivienda aspectoVivienda) {
        aspectoVivienda.setFichaSocioeconomica(fichaSocioeconomicaService.findByPaciente(idPaciente));
        return service.save(aspectoVivienda);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar aspecto de vivienda por id", notes = "Se debe enviar el id", response = AspectoVivienda.class)
    public AspectoVivienda retrieve(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar aspecto de vivienda por id", notes = "Se debe enviar el id", response = AspectoVivienda.class)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("")
    @ApiOperation(value = "Buscar lista de aspectos de vivienda por paciente", notes = "", response = AspectoVivienda.class)
    public List<AspectoVivienda> listByAntecedentePersonal(@PathVariable Long idPaciente) {
        return service.findByFichaSocioeconomica((fichaSocioeconomicaService.findByPaciente(idPaciente)).getId());
    }

    @GetMapping("/all")
    @ApiOperation(value = "Buscar lista de aspectos de vivienda", notes = "", response = AspectoVivienda.class)
    public List<AspectoVivienda> list() {
        return service.findAll();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualizar aspecto de vivienda por id", notes = "Se debe enviar el body y el id a actualizar", response = AspectoVivienda.class)
    public AspectoVivienda update(@PathVariable Long idPaciente, @Valid @RequestBody AspectoVivienda aspectoVivienda, @PathVariable Long id){
        aspectoVivienda.setFichaSocioeconomica(fichaSocioeconomicaService.findByPaciente(idPaciente));
        AspectoVivienda aspectoVivienda1 = service.findById(id);
        aspectoVivienda1=aspectoVivienda;
        return (service.save(aspectoVivienda1));
    }
}
