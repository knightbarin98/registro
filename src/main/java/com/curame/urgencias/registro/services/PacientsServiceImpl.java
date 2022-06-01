package com.curame.urgencias.registro.services;

import com.curame.urgencias.registro.models.entity.Pacient;
import com.curame.urgencias.registro.repository.PacientDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PacientsServiceImpl implements IPacientsService{
    @Autowired
    private PacientDao repository;

    @Override
    public List<Pacient> getPacients() {
        log.info("obtener objetos: {}", this);
        List<Pacient> pacients = new ArrayList<>();
        repository.findAll().forEach(pacient -> pacients.add(pacient));
        return pacients;
    }

    @Override
    public Pacient getPacient(Long id) {
        log.info("obtener objetos id:" + id + " {}", this);
        Pacient pacient = repository.findById(id).orElse(null);
        return pacient;
    }

    @Override
    public Pacient create(Pacient pacient) {
        log.info("create objeto {} , {}", pacient, this);
        Pacient newPacient = repository.save(pacient);
        return newPacient;
    }

    @Override
    public Pacient update(Pacient pacient, Long id) {
        Pacient pacientdb = repository.findById(id).orElse(null);
        if (pacientdb == null) {
            return null;
        }

        pacientdb.setFirstname(pacient.getFirstname());
        pacientdb.setLastname(pacient.getLastname());
        pacientdb.setAddress(pacient.getAddress());
        pacientdb.setNeighborhood(pacient.getNeighborhood());
        pacientdb.setZipCode(pacient.getZipCode());

        return repository.save(pacientdb);
    }

    @Override
    public void delete(Long id) {
        log.info("delete objeto id: " + id + " {}", this);
        repository.deleteById(id);
    }
}
