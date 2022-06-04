package com.curame.urgencias.registro.controllers;

import com.curame.urgencias.registro.models.entity.Er;
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
    public List<Er> getEmergencyRecords(){
        log.info("request GET all: {}",this );
        return service.getEmergencyRecords();
    }

    @GetMapping("/emergency-records/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Er getEmergencyRecord(@PathVariable Long id){
        log.info("request GET :"+id+" {}",this );
        return service.getEmergencyRecord(id);
    }

    @PostMapping("/emergency-records")
    @ResponseStatus(HttpStatus.CREATED)
    public Er create(@RequestBody Er emergencyrecord){
        log.info("request create : {}",this );
        return service.create(emergencyrecord);
    }

    @PutMapping("/emergency-records/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Er update(@RequestBody Er emergencyrecord, @PathVariable Long id){
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
