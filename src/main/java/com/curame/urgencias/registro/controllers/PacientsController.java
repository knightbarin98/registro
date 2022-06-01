package com.curame.urgencias.registro.controllers;

import com.curame.urgencias.registro.models.entity.Pacient;
import com.curame.urgencias.registro.services.IPacientsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PacientsController {

    @Autowired
    public IPacientsService service;

    @GetMapping("/pacients")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Pacient> getPacients(){
        log.info("request GET all: {}",this );
        return service.getPacients();
    }

    @GetMapping("/pacients/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Pacient getPacient(@PathVariable Long id){
        log.info("request GET :"+id+" {}",this );
        return service.getPacient(id);
    }

    @PostMapping("/pacients")
    @ResponseStatus(HttpStatus.CREATED)
    public Pacient create(@RequestBody Pacient pacient){
        log.info("request create : {}",this );
        return service.create(pacient);
    }

    @PutMapping("/pacients/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Pacient update(@RequestBody Pacient pacient, @PathVariable Long id){
        log.info("request update : {}",this );
        return service.update(pacient,id);
    }

    @DeleteMapping("/pacients/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        log.info("request delete : {}",this );
        service.delete(id);
    }
}
