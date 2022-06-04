package com.curame.urgencias.registro.services;

import com.curame.urgencias.registro.models.entity.Er;

import java.util.List;

public interface IEmergencyRecordsService {
    public List<Er> getEmergencyRecords();
    public Er getEmergencyRecord(Long id);
    public Er create (Er er);
    public Er update (Er er, Long id);
    public void delete(Long id);
}
