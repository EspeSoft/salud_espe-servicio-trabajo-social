package com.saludespe.trabajosocial.model.dao;

import com.saludespe.trabajosocial.model.entities.Familiar;
import org.springframework.data.repository.CrudRepository;
public interface IFamiliarDao extends CrudRepository<Familiar, Long> {
}
