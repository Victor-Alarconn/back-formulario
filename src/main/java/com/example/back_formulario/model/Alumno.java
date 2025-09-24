package com.example.back_formulario.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Alumno extends Persona {
    private String grado;
}
