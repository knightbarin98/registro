package com.curame.urgencias.registro.services;

import com.curame.urgencias.registro.models.entity.EmergencyRecord;

import java.util.List;

public interface IEmergencyRecordsService {
    public List<EmergencyRecord> getEmergencyRecords();
    public EmergencyRecord getEmergencyRecord(Long id);
    public EmergencyRecord create (EmergencyRecord emergencyRecord);
    public EmergencyRecord update (EmergencyRecord emergencyRecord, Long id);
    public void delete(Long id);
}
