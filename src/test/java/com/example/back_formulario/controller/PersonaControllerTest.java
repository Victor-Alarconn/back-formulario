package com.example.back_formulario.controller;

import com.example.back_formulario.model.Alumno;
import com.example.back_formulario.service.PersonaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PersonaControllerTest {

    private PersonaService personaService;
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        personaService = Mockito.mock(PersonaService.class);
        PersonaController controller = new PersonaController(personaService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void buscarPorId_existente_deberiaResponder200() throws Exception {
        Alumno alumno = new Alumno();
        alumno.setId(1L);
        alumno.setNombre("Juan");
        alumno.setCorreo("juan@test.com");

        when(personaService.buscarPorId(1L)).thenReturn(alumno);

        mockMvc.perform(get("/api/personas/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
