package com.curame.urgencias.registro.repository;

import com.curame.urgencias.registro.models.entity.Er;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergencyRecordDao extends CrudRepository<Er,Long> {
}
