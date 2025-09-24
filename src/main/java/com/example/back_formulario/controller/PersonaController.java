package com.example.back_formulario.controller;

import com.example.back_formulario.model.Alumno;
import com.example.back_formulario.model.Profesor;
import com.example.back_formulario.model.Persona;
import com.example.back_formulario.service.PersonaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    // Crear alumno
    @PostMapping("/alumnos")
    public Alumno crearAlumno(@RequestBody Alumno alumno) {
        return (Alumno) personaService.crear(alumno);
    }

    // Crear profesor
    @PostMapping("/profesores")
    public Profesor crearProfesor(@RequestBody Profesor profesor) {
        return (Profesor) personaService.crear(profesor);
    }

    // Listar todos
    @GetMapping
    public List<Persona> listar() {
        return personaService.listar();
    }

    // Buscar por id
    @GetMapping("/{id}")
    public Persona buscarPorId(@PathVariable Long id) {
        return personaService.buscarPorId(id);
    }

    @PutMapping("/alumnos/{id}")
    public Alumno actualizarAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
        return (Alumno) personaService.actualizar(id, alumno);
    }

    @PutMapping("/profesores/{id}")
    public Profesor actualizarProfesor(@PathVariable Long id, @RequestBody Profesor profesor) {
        return (Profesor) personaService.actualizar(id, profesor);
    }

    // 🔹 Eliminar (DELETE)
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        personaService.eliminar(id);
    }
}

