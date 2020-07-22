package com.saludespe.trabajosocial.controller;

import com.saludespe.trabajosocial.model.entities.FichaSocioeconomica;
import com.saludespe.trabajosocial.model.entities.GrupoFamiliar;
import com.saludespe.trabajosocial.model.services.interfaces.IGrupoFamiliarService;
import com.saludespe.trabajosocial.model.services.interfaces.IFichaSocioeconomicaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RequestMapping(value="{idPaciente}/grupos-familiares")
@Validated
@RestController
public class GrupoFamiliarController {
    private static String familiarNotFoundMessage = "No existe grupo familiar para el paciente: ";

    @Autowired
    private IGrupoFamiliarService service;

    @Autowired
    private IFichaSocioeconomicaService fichaSocioeconomicaService;

    @PostMapping("/")
    @ApiOperation(
            value = "Ingresar grupo familiar",
            notes = "Se debe enviar el body en formato Json",
            response = GrupoFamiliar.class)
    public GrupoFamiliar save(@PathVariable Long idPaciente,
                              @Valid @RequestBody GrupoFamiliar aspectoSocial) {
        Optional<FichaSocioeconomica> fichaSocioeconomica = fichaSocioeconomicaService.findByPaciente(idPaciente);
        if (fichaSocioeconomica.isPresent()){
            aspectoSocial.setFichaSocioeconomica(fichaSocioeconomica.get());
            return  service.save(aspectoSocial);
        }else  {
            throw new EntityNotFoundException(familiarNotFoundMessage + idPaciente);
        }

    }


    @GetMapping("/{id}")
    @ApiOperation(
            value = "Buscar grupo familiar por id",
            notes = "Se debe enviar el id",
            response = GrupoFamiliar.class)
    public GrupoFamiliar retrieve(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Eliminar grupo familiar por id",
            notes = "Se debe enviar el id",
            response = GrupoFamiliar.class)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @DeleteMapping("/delete-all")
    @ApiOperation(
            value = "Eliminar una lista de grupo familiar",
            notes = "Se debe enviar una lista",
            response = GrupoFamiliar.class)
    public void deleteAll(@RequestBody List<GrupoFamiliar> grupoFamiliarList) {
        service.deleteAll(grupoFamiliarList);
    }


    @GetMapping("")
    @ApiOperation(
            value = "Buscar lista de grupo familiar por paciente",
            notes = "",
            response = GrupoFamiliar.class)
    public List<GrupoFamiliar> grupoFamiliarList(@PathVariable Long idPaciente) {
        Optional<FichaSocioeconomica> fichaSocioeconomica = fichaSocioeconomicaService.findByPaciente(idPaciente);
        if(fichaSocioeconomica.isPresent()){
            return service.findByFichaSocioeconomica(fichaSocioeconomica.get().getId());
        }else {
            throw new EntityNotFoundException(familiarNotFoundMessage + idPaciente);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(
            value = "Actualizar grupo familiar por id",
            notes = "Se debe enviar el body y el id a actualizar",
            response = GrupoFamiliar.class)
    public GrupoFamiliar update(
            @PathVariable Long idPaciente,
            @Valid @RequestBody GrupoFamiliar grupoFamiliar, @PathVariable Long id){
        Optional<FichaSocioeconomica> fichaSocioeconomica = fichaSocioeconomicaService.findByPaciente(idPaciente);
        if (fichaSocioeconomica.isPresent()){
            GrupoFamiliar familiar = service.findById(id);
            familiar.setEdad(grupoFamiliar.getEdad());
            familiar.setEstadoCivil(grupoFamiliar.getEstadoCivil());
            familiar.setEstadoSalud(grupoFamiliar.getEstadoSalud());
            familiar.setEstudioRealizado(grupoFamiliar.getEstudioRealizado());
            familiar.setNombreCompleto(grupoFamiliar.getNombreCompleto());
            familiar.setParentesco(grupoFamiliar.getParentesco());
            familiar.setVinculacionLaboral(grupoFamiliar.getVinculacionLaboral());
             return service.save(familiar);
        }else{
            throw new EntityNotFoundException(familiarNotFoundMessage + idPaciente);
        }
    }
}
