package com.example.back_formulario.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Profesor extends Persona implements Universidad {
    private String materia;
    private Float salario;
    private String dependencia;

    @Override
    public String obtenerHorario() {
        return "El profesor " + getNombre() + " dicta clase en las mañanas.";
    }

    @Override
    public String irAClase() {
        return "El profesor " + getNombre() + " está dando clase.";
    }

    @Override
    public String obtenerPrograma() {
        return "El profesor " + getNombre() + " enseña en la dependencia " + dependencia;
    }

    @Override
    public String obtenerPaseParqueadero() {
        return "El profesor " + getNombre() + " obtuvo pase de parqueadero.";
    }
}
