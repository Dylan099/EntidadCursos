package com.CultOfTheUnicorn.demo;

public class CursoNotFoundException extends RuntimeException{
    CursoNotFoundException(Long id) {
        super("No se encontro el curso " + id);
    }
}
