package com.curame.urgencias.registro.repository;

import com.curame.urgencias.registro.models.entity.Pacient;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "pacients")
public interface PacientDao extends PagingAndSortingRepository<Pacient,Long> {
}
