package com.saludespe.servicio.trabajosocial.fichasocioeconomica.repository;

import com.saludespe.servicio.trabajosocial.fichasocioeconomica.model.AspectoSocial;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IAspectoSocialDAO extends CrudRepository<AspectoSocial, Long> {
    @Query(value = "SELECT * FROM ASPECTOS_SOCIALES app WHERE app.id_ficha_socioeconomica = ?1", nativeQuery = true)
     List<AspectoSocial> findByFichaSocioeconomica(Long idFichaSocioeconomica);

}
