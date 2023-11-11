package com.backendips.backendips.services;

import com.backendips.backendips.models.Cita;
import com.backendips.backendips.models.Persona;
import com.backendips.backendips.repositories.CitaRepository;
import com.backendips.backendips.repositories.MedicoRepository;
import com.backendips.backendips.repositories.PacienteRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsNotificacionService {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;



    public static final String ACCOUNT_SID = "ACadba012815697236063fdebeedcc09fa";
    public static final String AUTH_TOKEN = "022d02097b3931cd5ff241e4569898d7";

    public void notificarUsuarioSMS(int idCita, int idPaciente){
        Cita cita = citaRepository.findCitaById(idCita);
        String telefono = pacienteRepository.findPacienteById(idPaciente).getTelefono();

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("+57"+telefono),
                        new com.twilio.type.PhoneNumber("+12569739332"),
                        "Fecha Cita: "+cita.getFecha()+", Doctor: "+cita.getMedico().getPersona().getNombre())
                .create();
        System.out.println("Mensaje Envidado al: "+telefono);
        //System.out.println(message.getSid());
    }
}
