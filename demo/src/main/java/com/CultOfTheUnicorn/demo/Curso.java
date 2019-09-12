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

    public String getHorario(){
       return this.horario + " " + this.aula;
    }
    public void setHorario(String horario){
       String[] parts = horario.split(" ");
       this.horario = parts[0];
        this.horario = parts[1];
    }
    @Override
    public String toString(){
       return String.format(
               "Curso[id=%d, nombre= '%s', horario= '%s', aula= '%s']",
               id,nombre,horario,aula);
    }
}
