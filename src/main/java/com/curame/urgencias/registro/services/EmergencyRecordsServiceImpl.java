package com.curame.urgencias.registro.services;

import com.curame.urgencias.registro.models.entity.EmergencyRecord;
import com.curame.urgencias.registro.repository.EmergencyRecordDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmergencyRecordsServiceImpl implements IEmergencyRecordsService{
    @Autowired
    private EmergencyRecordDao repository;

    @Override
    public List<EmergencyRecord> getEmergencyRecords() {
        log.info("obtener objetos: {}", this);
        List<EmergencyRecord> emergencyRecords = new ArrayList<>();
        repository.findAll().forEach(emergencyRecord -> emergencyRecords.add(emergencyRecord));
        return emergencyRecords;
    }

    @Override
    public EmergencyRecord getEmergencyRecord(Long id) {
        log.info("obtener objetos id:" + id + " {}", this);
        EmergencyRecord emergencyRecord = repository.findById(id).orElse(null);
        return emergencyRecord;
    }

    @Override
    public EmergencyRecord create(EmergencyRecord emergencyRecord) {
        log.info("create objeto {} , {}", emergencyRecord, this);
        EmergencyRecord newEmergencyRecord = repository.save(emergencyRecord);
        return newEmergencyRecord;
    }

    @Override
    public EmergencyRecord update(EmergencyRecord emergencyRecord, Long id) {
        EmergencyRecord emergencyRecorddb = repository.findById(id).orElse(null);
        if (emergencyRecorddb == null) {
            return null;
        }

        emergencyRecorddb.setAllergies(emergencyRecord.getAllergies());
        emergencyRecorddb.setAllergiesDescription(emergencyRecord.getAllergiesDescription());
        emergencyRecorddb.setNss(emergencyRecord.getNss());
        emergencyRecorddb.setInsuranceCode(emergencyRecord.getInsuranceCode());
        emergencyRecorddb.setInsuranceCompany(emergencyRecord.getInsuranceCompany());
        emergencyRecorddb.setDiagnosticReview(emergencyRecord.getDiagnosticReview());

        return repository.save(emergencyRecorddb);
    }

    @Override
    public void delete(Long id) {
        log.info("delete objeto id: " + id + " {}", this);
        repository.deleteById(id);
    }
}
