package com.saludespe.trabajosocial.controller;


import com.saludespe.trabajosocial.model.entities.AspectoVivienda;
import com.saludespe.trabajosocial.model.entities.FichaSocioeconomica;
import com.saludespe.trabajosocial.model.services.interfaces.IAspectosViviendaService;
import com.saludespe.trabajosocial.model.services.interfaces.IFichaSocioeconomicaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

import java.util.Optional;

@RequestMapping(value="{idPaciente}/aspectos-vivienda")
@Validated
@RestController
public class AspectoViviendaController {

    private static String aspectoNotFoundMessage = "No existe un registro de este tipo,  para el paciente: ";

    @Autowired
    private IAspectosViviendaService service;

    @Autowired
    private IFichaSocioeconomicaService fichaSocioeconomicaService;

    @PostMapping("/")
    @ApiOperation(
            value = "Ingresar aspectos de vivienda",
            notes = "Se debe enviar el body en formato Json",
            response = AspectoVivienda.class)
    public AspectoVivienda save(@PathVariable Long idPaciente,
                              @Valid @RequestBody AspectoVivienda aspectoVivienda) {
        Optional<FichaSocioeconomica> fichaSocioeconomica = fichaSocioeconomicaService.findByPaciente(idPaciente);
        if (fichaSocioeconomica.isPresent()){
            aspectoVivienda.setFichaSocioeconomica(fichaSocioeconomica.get());
            return  service.save(aspectoVivienda);
        }else  {
            throw new EntityNotFoundException(aspectoNotFoundMessage + idPaciente);
        }

    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Buscar aspecto de vivienda por id",
            notes = "Se debe enviar el id",
            response = AspectoVivienda.class)
    public AspectoVivienda retrieve(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar aspecto de vivienda por id", notes = "Se debe enviar el id", response = AspectoVivienda.class)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @DeleteMapping("/delete-all")
    @ApiOperation(
            value = "Eliminar una lista de aspectos de vivienda",
            notes = "Se debe enviar una lista",
            response = AspectoVivienda.class)
    public void deleteAll(@RequestBody List<AspectoVivienda> aspectoViviendas) {
        service.deleteAll(aspectoViviendas);
    }

    @GetMapping("")
    @ApiOperation(
            value = "Buscar lista de aspecto de vivienda por paciente", notes = "", response = AspectoVivienda.class)
    public List<AspectoVivienda> aspectoViviendaList(@PathVariable Long idPaciente) {
        Optional<FichaSocioeconomica> fichaSocioeconomica = fichaSocioeconomicaService.findByPaciente(idPaciente);
        if(fichaSocioeconomica.isPresent()){
            return service.findByFichaSocioeconomica(fichaSocioeconomica.get().getId());
        }else {
            throw new EntityNotFoundException(aspectoNotFoundMessage + idPaciente);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(
            value = "Actualizar aspecto de vivienda por id",
            notes = "Se debe enviar el body y el id a actualizar",
            response = AspectoVivienda.class)
    public AspectoVivienda update(
            @PathVariable Long idPaciente,
            @Valid @RequestBody AspectoVivienda aspectoVivienda, @PathVariable Long id){
        Optional<FichaSocioeconomica> fichaSocioeconomica = fichaSocioeconomicaService.findByPaciente(idPaciente);
        if (fichaSocioeconomica.isPresent()){
            AspectoVivienda aspecto = service.findById(id);
            aspecto.setEstructura(aspectoVivienda.getEstructura());
            aspecto.setTenencia(aspectoVivienda.getTenencia());
            aspecto.setTieneaguaPotable(aspectoVivienda.getTieneaguaPotable());
            aspecto.setTieneAlcantarillado(aspectoVivienda.getTieneAlcantarillado());
            aspecto.setTieneLuzElectrica(aspectoVivienda.getTieneLuzElectrica());
            aspecto.setTieneTelefono(aspectoVivienda.getTieneTelefono());
            aspecto.setTipo(aspecto.getTipo());
            return service.save(aspecto);
        }else{
            throw new EntityNotFoundException(aspectoNotFoundMessage + idPaciente);
        }
    }
}
