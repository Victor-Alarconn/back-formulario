package com.example.back_formulario.exception;

public class PersonaNotFoundException extends RuntimeException {
    public PersonaNotFoundException(Long id) {
        super("No se encontró la persona con id " + id);
    }
}
