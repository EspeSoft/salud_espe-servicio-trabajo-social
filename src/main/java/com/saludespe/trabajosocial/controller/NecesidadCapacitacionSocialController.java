package com.saludespe.trabajosocial.controller;


import com.saludespe.trabajosocial.model.entities.NecesidadCapacitacionSocial;
import com.saludespe.trabajosocial.model.services.interfaces.IFichaSocioeconomicaService;
import com.saludespe.trabajosocial.model.services.interfaces.INecesidadCapacitacionSocialService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequestMapping(value="/necesidades-capacitacion-social")
@Validated
@RestController
public class NecesidadCapacitacionSocialController {

    @Autowired
    private INecesidadCapacitacionSocialService service;

    @Autowired
    private IFichaSocioeconomicaService fichaSocioeconomicaService;

    @PostMapping("")
    @ApiOperation(value = "Ingresar necesida de capacitación social", notes = "Se debe enviar el body en formato Json", response = NecesidadCapacitacionSocial.class)
    public NecesidadCapacitacionSocial save(@PathVariable Long idPaciente, @Valid @RequestBody NecesidadCapacitacionSocial necesidadCapacitacionSocial) {
        necesidadCapacitacionSocial.setFichaSocioeconomica(fichaSocioeconomicaService.findByPaciente(idPaciente));
        return service.save(necesidadCapacitacionSocial);
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar necesida de capacitación social por id", notes = "Se debe enviar el id", response = NecesidadCapacitacionSocial.class)
    public NecesidadCapacitacionSocial retrieve(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar necesida de capacitación social por id", notes = "Se debe enviar el id", response = NecesidadCapacitacionSocial.class)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("")
    @ApiOperation(value = "Buscar lista necesida de capacitación social de paciente", notes = "", response = NecesidadCapacitacionSocial.class)
    public List<NecesidadCapacitacionSocial> listByAntecedentePersonal(@PathVariable Long idPaciente) {
        return service.findByFichaSocioeconomica((fichaSocioeconomicaService.findByPaciente(idPaciente)).getId());
    }

    @GetMapping("/all")
    @ApiOperation(value = "Buscar lista de necesida de capacitación social", notes = "", response = NecesidadCapacitacionSocial.class)
    public List<NecesidadCapacitacionSocial> list() {
        return service.findAll();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualizar necesida de capacitación social por id", notes = "Se debe enviar el body y el id a actualizar", response = NecesidadCapacitacionSocial.class)
    public NecesidadCapacitacionSocial update(@PathVariable Long idPaciente, @Valid @RequestBody NecesidadCapacitacionSocial necesidadCapacitacionSocial, @PathVariable Long id){
        necesidadCapacitacionSocial.setFichaSocioeconomica(fichaSocioeconomicaService.findByPaciente(idPaciente));
        NecesidadCapacitacionSocial necesidadCapacitacionSocial1 = service.findById(id);
        necesidadCapacitacionSocial1=necesidadCapacitacionSocial;
        return (service.save(necesidadCapacitacionSocial1));
    }

}
