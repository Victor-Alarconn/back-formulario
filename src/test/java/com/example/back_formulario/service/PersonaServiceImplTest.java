package com.example.back_formulario.service;

import com.example.back_formulario.exception.PersonaNotFoundException;
import com.example.back_formulario.model.Alumno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonaServiceImplTest {

    private final PersonaServiceImpl personaService = new PersonaServiceImpl();

    @Test
    void crearAlumno_deberiaAsignarId() {
        Alumno alumno = new Alumno();
        alumno.setNombre("Juan");
        alumno.setCorreo("juan@test.com");
        alumno.setGrado("10");

        Alumno guardado = (Alumno) personaService.crear(alumno);

        assertNotNull(guardado.getId());
        assertEquals("Juan", guardado.getNombre(), "El nombre del alumno no se guardó correctamente");
        assertEquals("juan@test.com", guardado.getCorreo());
    }

    @Test
    void buscarPorId_inexistente_deberiaLanzarExcepcion() {
        assertThrows(PersonaNotFoundException.class, () -> {
            personaService.buscarPorId(999L);
        });
    }
}
