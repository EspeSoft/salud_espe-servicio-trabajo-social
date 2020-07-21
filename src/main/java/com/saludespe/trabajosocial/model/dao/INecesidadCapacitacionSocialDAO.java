package com.saludespe.trabajosocial.model.dao;

import com.saludespe.trabajosocial.model.entities.NecesidadCapacitacionSocial;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface INecesidadCapacitacionSocialDAO extends CrudRepository<NecesidadCapacitacionSocial, Long> {
    @Query(value = "SELECT * FROM NECESIDAD_CAPACITACION_SOCIAL app WHERE app.id_ficha_socioeconomica = ?1", nativeQuery = true)
    public List<NecesidadCapacitacionSocial> findByFichaSocioeconomica(Long idFichaSocioeconomica);

}
