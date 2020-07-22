package com.saludespe.trabajosocial.model.dao;

import com.saludespe.trabajosocial.model.entities.AspectoSocial;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IAspectoSocialDAO extends CrudRepository<AspectoSocial, Long> {
    @Query(value = "SELECT * FROM ASPECTOS_SOCIALES app WHERE app.id_ficha_socioeconomica = ?1", nativeQuery = true)
     List<AspectoSocial> findByFichaSocioeconomica(Long idFichaSocioeconomica);

}
