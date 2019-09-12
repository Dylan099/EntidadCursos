package com.CultOfTheUnicorn.demo;

public class CursoNotFoundException extends RuntimeException {
    CursoNotFoundException(Long id){
        super("Could not find curso"+id);
    }
}
