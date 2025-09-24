package com.example.back_formulario.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Alumno extends Persona implements Universidad {
    private Long numatricula;
    private String grado;
    private Float notapromedio;

    @Override
    public String obtenerHorario() {
        return "El alumno " + getNombre() + " tiene horario de lunes a viernes.";
    }

    @Override
    public String irAClase() {
        return "El alumno " + getNombre() + " está asistiendo a clase.";
    }

    @Override
    public String obtenerPrograma() {
        return "El alumno " + getNombre() + " pertenece al programa " + grado;
    }

    @Override
    public String obtenerPaseParqueadero() {
        return "El alumno " + getNombre() + " obtuvo pase de parqueadero.";
    }
}
