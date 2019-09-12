package com.CultOfTheUnicorn.demo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Curso {
    private @Id @GeneratedValue Long id;
    private String nombre;
    private String horario;
    private String aula;

   Curso(){}

    Curso(String nombre, String horario, String aula) {
        this.nombre = nombre;
        this.horario = horario;
        this.aula = aula;
    }

    @Override
    public String toString(){
       return String.format(
               "Curso[id=%d, nombre= '%s', horario= '%s', aula= '%s']",
               id,nombre,horario,aula);
    }
}
