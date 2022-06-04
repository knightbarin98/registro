package com.curame.urgencias.registro.services;

import com.curame.urgencias.registro.models.entity.Er;
import com.curame.urgencias.registro.models.entity.Pacient;
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

    @Autowired
    private IPacientsService pacientsService;

    @Override
    public List<Er> getEmergencyRecords() {
        log.info("obtener objetos: {}", this);
        List<Er> ers = new ArrayList<>();
        repository.findAll().forEach(emergencyRecord -> {
            setPacientEntity(emergencyRecord, emergencyRecord.getPacientId());
            ers.add(emergencyRecord);
        });
        return ers;
    }

    @Override
    public Er getEmergencyRecord(Long id) {
        log.info("obtener objetos id:" + id + " {}", this);
        Er er = repository.findById(id).orElse(null);
        setPacientEntity(er,er.getPacientId());
        return er;
    }

    @Override
    public Er create(Er er) {
        log.info("create objeto {} , {}", er, this);
        Er newEr = repository.save(er);
        setPacientEntity(newEr,newEr.getPacientId());
        return newEr;
    }

    @Override
    public Er update(Er er, Long id) {
        Er emergencyRecorddb = repository.findById(id).orElse(null);
        if (emergencyRecorddb == null) {
            return null;
        }

        emergencyRecorddb.setAllergies(er.getAllergies());
        emergencyRecorddb.setAllergiesDescription(er.getAllergiesDescription());
        emergencyRecorddb.setNss(er.getNss());
        emergencyRecorddb.setInsuranceCode(er.getInsuranceCode());
        emergencyRecorddb.setInsuranceCompany(er.getInsuranceCompany());
        emergencyRecorddb.setDiagnosticReview(er.getDiagnosticReview());

        Er updatedEr = repository.save(emergencyRecorddb);
        setPacientEntity(updatedEr, updatedEr.getPacientId());
        return updatedEr;
    }

    @Override
    public void delete(Long id) {
        log.info("delete objeto id: " + id + " {}", this);
        repository.deleteById(id);
    }

    private void setPacientEntity(Er emergencyRecord, Long id){
        Pacient p = pacientsService.getPacient(emergencyRecord.getPacientId());
        emergencyRecord.setPacient(new Pacient(
                p.getId(),
                p.getFirstname(),
                p.getLastname(),
                p.getAddress(),
                p.getNeighborhood(),
                p.getZipCode(),
                null
        ));
    }
}
