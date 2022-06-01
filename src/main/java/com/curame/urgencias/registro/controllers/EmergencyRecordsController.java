package com.curame.urgencias.registro.controllers;

import com.curame.urgencias.registro.models.entity.EmergencyRecord;
import com.curame.urgencias.registro.services.IEmergencyRecordsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class EmergencyRecordsController {

    @Autowired
    public IEmergencyRecordsService service;

    @GetMapping("/emergency-records")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<EmergencyRecord> getEmergencyRecords(){
        log.info("request GET all: {}",this );
        return service.getEmergencyRecords();
    }

    @GetMapping("/emergency-records/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public EmergencyRecord getEmergencyRecord(@PathVariable Long id){
        log.info("request GET :"+id+" {}",this );
        return service.getEmergencyRecord(id);
    }

    @PostMapping("/emergency-records")
    @ResponseStatus(HttpStatus.CREATED)
    public EmergencyRecord create(@RequestBody EmergencyRecord emergencyrecord){
        log.info("request create : {}",this );
        return service.create(emergencyrecord);
    }

    @PutMapping("/emergency-records/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public EmergencyRecord update(@RequestBody EmergencyRecord emergencyrecord, @PathVariable Long id){
        log.info("request update : {}",this );
        return service.update(emergencyrecord,id);
    }

    @DeleteMapping("/emergency-records/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        log.info("request delete : {}",this );
        service.delete(id);
    }
}
