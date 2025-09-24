package com.example.back_formulario.controller;

import com.example.back_formulario.model.Alumno;
import com.example.back_formulario.model.Profesor;
import com.example.back_formulario.service.PersonaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    // Registrar Alumno
    @PostMapping("/alumnos")
    public Alumno crearAlumno(@RequestBody Alumno alumno) {
        return (Alumno) personaService.crear(alumno);
    }

    // Registrar Profesor
    @PostMapping("/profesores")
    public Profesor crearProfesor(@RequestBody Profesor profesor) {
        return (Profesor) personaService.crear(profesor);
    }

    // Listar todas las personas (alumnos y profesores)
    @GetMapping("/personas")
    public List<?> listar() {
        return personaService.listar();
    }

    // Buscar persona por id
    @GetMapping("/personas/{id}")
    public Object buscarPorId(@PathVariable Long id) {
        return personaService.buscarPorId(id);
    }
}
