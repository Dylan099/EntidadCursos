package com.CultOfTheUnicorn.demo;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;


@RestController
public class CursoController {
    private final CursoRepository repository;
    private final CursoResourceAssembler assembler;

    CursoController(CursoRepository repository, CursoResourceAssembler assembler){
        this.repository = repository;
        this.assembler = assembler;
    }

    // Agregando Root



    @PostMapping("/cursos")
    Curso newCurso(@RequestBody Curso newCurso){
        return repository.save(newCurso);
    }


//getting a single item resource
@GetMapping("/cursos/{id}")
Resource<Curso> one(@PathVariable Long id) {

    Curso curso = repository.findById(id)
            .orElseThrow(() -> new CursoNotFoundException(id));

    return assembler.toResource(curso);
}

// getting an aggregaete root resource
@GetMapping("/cursos")
Resources<Resource<Curso>> all() {

    List<Resource<Curso>> cursos = repository.findAll().stream()
            .map(assembler::toResource)
            .collect(Collectors.toList());

    return new Resources<>(cursos,
            linkTo(methodOn(CursoController.class).all()).withSelfRel());
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
