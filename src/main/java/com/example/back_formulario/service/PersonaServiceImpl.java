package com.example.back_formulario.service;

import com.example.back_formulario.model.Persona;
import org.springframework.stereotype.Service;
import com.example.back_formulario.exception.DuplicatePersonaException;
import com.example.back_formulario.exception.InvalidDataException;
import com.example.back_formulario.exception.PersonaNotFoundException;
import com.example.back_formulario.model.Persona;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final Map<Long, Persona> personas = new HashMap<>();
    private Long contadorId = 1L;

    @Override
    public Persona crear(Persona persona) {
        // Validación básica
        if (persona.getNombre() == null || persona.getNombre().isBlank()) {
            throw new InvalidDataException("El nombre no puede estar vacío");
        }
        if (persona.getCorreo() == null || !persona.getCorreo().contains("@")) {
            throw new InvalidDataException("El correo no es válido");
        }

        // Verificar correo duplicado
        boolean correoDuplicado = personas.values().stream()
                .anyMatch(p -> p.getCorreo().equalsIgnoreCase(persona.getCorreo()));

        if (correoDuplicado) {
            throw new DuplicatePersonaException(persona.getCorreo());
        }

        // Crear persona
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
        Persona persona = personas.get(id);
        if (persona == null) {
            throw new PersonaNotFoundException(id);
        }
        return persona;
    }

    @Override
    public Persona actualizar(Long id, Persona persona) {
        if (!personas.containsKey(id)) {
            throw new PersonaNotFoundException(id);
        }
        if (persona.getNombre() == null || persona.getNombre().isBlank()) {
            throw new InvalidDataException("El nombre no puede estar vacío");
        }
        if (persona.getCorreo() == null || !persona.getCorreo().contains("@")) {
            throw new InvalidDataException("El correo no es válido");
        }

        persona.setId(id);
        personas.put(id, persona);
        return persona;
    }

    @Override
    public void eliminar(Long id) {
        if (!personas.containsKey(id)) {
            throw new PersonaNotFoundException(id);
        }
        personas.remove(id);
    }
}
