package com.saludespe.trabajosocial.model.dao;

import com.saludespe.trabajosocial.model.entities.IngresoEconomico;
import com.saludespe.trabajosocial.model.entities.Problema;
import org.springframework.data.repository.CrudRepository;

public interface IProblemaDAO  extends CrudRepository<Problema, Long> {

}
