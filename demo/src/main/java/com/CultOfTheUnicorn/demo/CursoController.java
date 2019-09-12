package com.CultOfTheUnicorn.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CursoController {
    private final CursoRepository repository;

    CursoController(CursoRepository repository){
        this.repository = repository;
    }

    // Agregando Root

    @GetMapping("/cursos")
    List<Curso> all (){
        return repository.findAll();
    }

    @PostMapping("/cursos")
    Curso newCurso(@RequestBody Curso newCurso){
        return repository.save(newCurso);
    }

    // Single Item
    @GetMapping("/cursos/{id}")
    Curso one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new CursoNotFoundException(id));
    }

    @PutMapping("/cursos/{id}")
    Curso replaceCurso(@RequestBody Curso newCurso,@PathVariable Long id){
        return repository.findById(id)
                .map(curso -> {
                    curso.setNombre(newCurso.getNombre());
                    curso.setHorario(newCurso.getHorario());
                    curso.setAula(newCurso.getAula());
                    return repository.save(curso);
                })
                .orElseGet(()->{
                    newCurso.setId(id);
                    return repository.save(newCurso);
                });
    }
    @DeleteMapping("/cursos/{id}")
    void deleteCurso(@PathVariable Long id){
        repository.deleteById(id);
    }

}
