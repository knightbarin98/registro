package com.curame.urgencias.registro.services;

import com.curame.urgencias.registro.models.entity.Pacient;

import java.util.List;

public interface IPacientsService {
    public List<Pacient> getPacients();
    public Pacient getPacient(Long id);
    public Pacient create (Pacient pacient);
    public Pacient update (Pacient pacient, Long id);
    public void delete(Long id);
}
