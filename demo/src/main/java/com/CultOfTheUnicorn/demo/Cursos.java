package com.CultOfTheUnicorn.demo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Cursos {
    private @Id @GeneratedValue Long id;
    private String nombre;
    private String horario;
    private String aula;

   Cursos(){}

    Cursos(String nombre, String horario, String aula) {
        this.nombre = nombre;
        this.horario = horario;
        this.aula = aula;
    }
}
