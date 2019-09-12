package com.CultOfTheUnicorn.demo;

import ch.qos.logback.core.status.Status;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "HORARIOS_ESTUDIANTE")
public class Horarios {
    private @Id
    @GeneratedValue
    Long id;

    private String nombre_docente;

    Horarios(){ }
    Horarios(String nombre_docente) {
        this.nombre_docente = nombre_docente;
    }
}
