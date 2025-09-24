package com.example.back_formulario.service;

import com.example.back_formulario.model.Persona;
import java.util.List;

public interface PersonaService {
    Persona crear(Persona persona);
    List<Persona> listar();
    Persona buscarPorId(Long id);
}
