package com.backendips.backendips.services;

import com.backendips.backendips.models.Agenda;
import com.backendips.backendips.models.Cita;
import com.backendips.backendips.repositories.AgendaRepository;
import com.backendips.backendips.repositories.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private CitaRepository citaRepository;
    public List<Agenda> getAllAgenda() {
        return agendaRepository.findAll();
    }


}
