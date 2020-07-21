package com.saludespe.trabajosocial.controller;


import com.saludespe.trabajosocial.model.entities.Familiar;
import com.saludespe.trabajosocial.model.services.interfaces.IFamiliarService;
import com.saludespe.trabajosocial.model.services.interfaces.IFichaSocioeconomicaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequestMapping(value="/familiar")
@Validated
@RestController
public class FamiliarController {
    @Autowired
    private IFamiliarService service;

    @Autowired
    private IFichaSocioeconomicaService fichaSocioeconomicaService;

    @PostMapping("")
    @ApiOperation(value = "Ingresar grupo familiar", notes = "Se debe enviar el body en formato Json", response = Familiar.class)
    public Familiar save(@PathVariable Long idPaciente, @Valid @RequestBody Familiar familiar) {
        familiar.setFichaSocioeconomica(fichaSocioeconomicaService.findByPaciente(idPaciente));
        return service.save(familiar);
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar grupo familiar por id", notes = "Se debe enviar el id", response = Familiar.class)
    public Familiar retrieve(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar grupo familiar por id", notes = "Se debe enviar el id", response = Familiar.class)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("")
    @ApiOperation(value = "Buscar lista de grupo familiarpor paciente", notes = "", response = Familiar.class)
    public List<Familiar> listByAntecedentePersonal(@PathVariable Long idPaciente) {
        return service.findByFichaSocioeconomica((fichaSocioeconomicaService.findByPaciente(idPaciente)).getId());
    }

    @GetMapping("/all")
    @ApiOperation(value = "Buscar lista de grupo familiar", notes = "", response = Familiar.class)
    public List<Familiar> list() {
        return service.findAll();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualizar grupo familiar por id", notes = "Se debe enviar el body y el id a actualizar", response = Familiar.class)
    public Familiar update(@PathVariable Long idPaciente, @Valid @RequestBody Familiar familiar, @PathVariable Long id){
        familiar.setFichaSocioeconomica(fichaSocioeconomicaService.findByPaciente(idPaciente));
        Familiar familiar1 = service.findById(id);
        familiar1=familiar;
        return (service.save(familiar1));
    }
}
