package com.example.back_formulario.model;
import lombok.Data;
@Data
public abstract  class Persona {
    private Long id;
    private String nombre;
    private String correo;
}
