package com.curame.urgencias.registro.repository;

import com.curame.urgencias.registro.models.entity.Pacient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacientDao extends CrudRepository<Pacient,Long> {
}
