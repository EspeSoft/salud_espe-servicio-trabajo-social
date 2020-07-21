package com.saludespe.trabajosocial.model.dao;

import com.saludespe.trabajosocial.model.entities.FichaSocioeconomica;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IFichaSocioeconomicaDAO extends CrudRepository<FichaSocioeconomica, Long> {
    @Query(value = "SELECT * FROM FICHA_SOCIOECONOMICA ap WHERE ap.id_paciente = ?1", nativeQuery = true)
    public FichaSocioeconomica findByPaciente(Long idPaciente);
    
}