package com.example.back_formulario.exception;

public class DuplicatePersonaException extends RuntimeException {
    public DuplicatePersonaException(String correo) {
        super("Ya existe una persona registrada con el correo: " + correo);
    }
}
