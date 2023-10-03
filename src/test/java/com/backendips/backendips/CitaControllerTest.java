package com.backendips.backendips;

import com.backendips.backendips.models.Cita;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class CitaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllCitas() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cita")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testCreateCita() throws Exception {
        Cita cita = new Cita();
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/cita")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(cita)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    public void testGetCitaById() throws Exception {
        int citaId = 10;

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cita/{id}", citaId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    public void testUpdateCitaPaciente() throws Exception {
        int citaId = 15;
        int pacienteId = 7;
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/cita/{idCita}", citaId)
                        .param("idPaciente", String.valueOf(pacienteId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    public void testUpdateEstadoCita() throws Exception {
        int citaId = 10;
        int estadoCitaId = 1;
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/cita")
                        .param("idCita", String.valueOf(citaId))
                        .param("idEstadoCita", String.valueOf(estadoCitaId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    public void testGetCitasByMedicoAndFecha() throws Exception {
        int idMedico = 6;
        String fecha = "2023-10-03";

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cita/{idMedico}", idMedico)
                        .param("fecha", fecha)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    public void testDeleteCita() throws Exception {
        int idCita = 51;

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/cita/{id}", idCita)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    public void testGetCitasByEspecialidad() throws Exception {
        int idEspecialidad = 1;
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cita/cita_especialidad/{idEspecialidad}", idEspecialidad)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    public void testGetCitasByEspecialidadAndMedico() throws Exception {
        int idEspecialidad = 1;
        String nombreMedico = "Teirtza";

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cita/{idEspecialidad}/{nombreMedico}", idEspecialidad, nombreMedico)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

    }

    @Test
    public void testGetCitasByCedulaAndIdEstadoCita() throws Exception {
        String numeroDocumento = "1234567890";
        int idEstadoCita = 1;
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cita/paciente/{numeroDocumento}/{idEstadoCita}", numeroDocumento, idEstadoCita)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

    }

    private String asJsonString(Object obj) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
}

