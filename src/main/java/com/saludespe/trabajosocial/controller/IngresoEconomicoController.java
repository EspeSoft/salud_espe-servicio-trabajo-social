package com.saludespe.trabajosocial.controller;


import com.saludespe.trabajosocial.model.entities.IngresoEconomico;
import com.saludespe.trabajosocial.model.services.interfaces.IFichaSocioeconomicaService;
import com.saludespe.trabajosocial.model.services.interfaces.IIngresoEconomicoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;


@RequestMapping(value="/ingresos-economicos")
@Validated
@RestController
public class IngresoEconomicoController {

    @Autowired
    private IIngresoEconomicoService service;

    @Autowired
    private IFichaSocioeconomicaService fichaSocioeconomicaService;

    @PostMapping("")
    @ApiOperation(value = "Ingresar ingreso económico", notes = "Se debe enviar el body en formato Json", response = IngresoEconomico.class)
    public IngresoEconomico save(@PathVariable Long idPaciente, @Valid @RequestBody IngresoEconomico ingresoEconomico) {
        ingresoEconomico.setFichaSocioeconomica(fichaSocioeconomicaService.findByPaciente(idPaciente));
        return service.save(ingresoEconomico);
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar ingreso económico por id", notes = "Se debe enviar el id", response = IngresoEconomico.class)
    public IngresoEconomico retrieve(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar ingreso económico por id", notes = "Se debe enviar el id", response = IngresoEconomico.class)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("")
    @ApiOperation(value = "Buscar lista de ingreso económico paciente", notes = "", response = IngresoEconomico.class)
    public List<IngresoEconomico> listByAntecedentePersonal(@PathVariable Long idPaciente) {
        return service.findByFichaSocioeconomica((fichaSocioeconomicaService.findByPaciente(idPaciente)).getId());
    }

    @GetMapping("/all")
    @ApiOperation(value = "Buscar lista de ingreso económico", notes = "", response = IngresoEconomico.class)
    public List<IngresoEconomico> list() {
        return service.findAll();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualizar ingreso familiar por id", notes = "Se debe enviar el body y el id a actualizar", response = IngresoEconomico.class)
    public IngresoEconomico update(@PathVariable Long idPaciente, @Valid @RequestBody IngresoEconomico ingresoEconomico, @PathVariable Long id){
        ingresoEconomico.setFichaSocioeconomica(fichaSocioeconomicaService.findByPaciente(idPaciente));
        IngresoEconomico ingresoEconomico1 = service.findById(id);
        ingresoEconomico1=ingresoEconomico;
        return (service.save(ingresoEconomico1));
    }

}
