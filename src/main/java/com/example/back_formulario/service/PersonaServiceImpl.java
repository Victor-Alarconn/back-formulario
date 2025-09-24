package com.example.back_formulario.service;

import com.example.back_formulario.model.Persona;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final Map<Long, Persona> personas = new HashMap<>();
    private Long contadorId = 1L;

    @Override
    public Persona crear(Persona persona) {
        persona.setId(contadorId++);
        personas.put(persona.getId(), persona);
        return persona;
    }

    @Override
    public List<Persona> listar() {
        return new ArrayList<>(personas.values());
    }

    @Override
    public Persona buscarPorId(Long id) {
        return personas.get(id);
    }
}
