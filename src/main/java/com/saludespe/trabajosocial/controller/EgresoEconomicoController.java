package com.saludespe.trabajosocial.controller;


import com.saludespe.trabajosocial.model.entities.EgresoEconomico;
import com.saludespe.trabajosocial.model.services.interfaces.IEgresoEconomicoService;
import com.saludespe.trabajosocial.model.services.interfaces.IFichaSocioeconomicaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;


@RequestMapping(value="/egresos-economicos")
@Validated
@RestController
public class EgresoEconomicoController {
    
    @Autowired
    private IEgresoEconomicoService service;

    @Autowired
    private IFichaSocioeconomicaService fichaSocioeconomicaService;

    @PostMapping("")
    @ApiOperation(value = "Ingresar egreso economico", notes = "Se debe enviar el body en formato Json", response = EgresoEconomico.class)
    public EgresoEconomico save(@PathVariable Long idPaciente, @Valid @RequestBody EgresoEconomico egresoEconomico) {
        egresoEconomico.setFichaSocioeconomica(fichaSocioeconomicaService.findByPaciente(idPaciente));
        return service.save(egresoEconomico);
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar aspecto de vivienda por id", notes = "Se debe enviar el id", response = EgresoEconomico.class)
    public EgresoEconomico retrieve(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar aspecto de vivienda por id", notes = "Se debe enviar el id", response = EgresoEconomico.class)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("")
    @ApiOperation(value = "Buscar lista de egresos económicos por paciente", notes = "", response = EgresoEconomico.class)
    public List<EgresoEconomico> listByAntecedentePersonal(@PathVariable Long idPaciente) {
        return service.findByFichaSocioeconomica((fichaSocioeconomicaService.findByPaciente(idPaciente)).getId());
    }


    @PutMapping("/{id}")
    @ApiOperation(value = "Actualizar antecedenteGinecologico por id", notes = "Se debe enviar el body y el id a actualizar", response = EgresoEconomico.class)
    public EgresoEconomico update(@PathVariable Long idPaciente, @Valid @RequestBody EgresoEconomico egresoEconomico, @PathVariable Long id){
        egresoEconomico.setFichaSocioeconomica(fichaSocioeconomicaService.findByPaciente(idPaciente));
        EgresoEconomico egresoEconomico1 = service.findById(id);
        egresoEconomico1=egresoEconomico;
        return (service.save(egresoEconomico1));
    }

}