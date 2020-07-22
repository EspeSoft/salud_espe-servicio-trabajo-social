package com.saludespe.trabajosocial.model.dao;

import com.saludespe.trabajosocial.model.entities.FichaSocioeconomica;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IFichaSocioeconomicaDAO extends CrudRepository<FichaSocioeconomica, Long> {
    @Query(value = "SELECT * FROM FICHAS_SOCIOECONOMICAS ap WHERE ap.id_paciente = ?1", nativeQuery = true)
   Optional<FichaSocioeconomica> findByPaciente(Long idPaciente);
    
}