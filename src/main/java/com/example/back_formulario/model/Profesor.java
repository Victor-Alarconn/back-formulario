package com.example.back_formulario.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Profesor extends Persona {
    private String materia;
}
