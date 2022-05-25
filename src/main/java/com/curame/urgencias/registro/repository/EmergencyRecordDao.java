package com.curame.urgencias.registro.repository;

import com.curame.urgencias.registro.models.entity.EmergencyRecord;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "emergency-records")
public interface EmergencyRecordDao extends PagingAndSortingRepository<EmergencyRecord,Long> {
}
