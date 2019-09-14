package com.CultOfTheUnicorn.demo;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;


@RestController
public class CursoController {
    private final CursoRepository repository;

    CursoController(CursoRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/Cursos")
    List<Curso> all() {
        return repository.findAll();
    }

    @PostMapping("/Cursos")
    Curso newEmployee(@RequestBody Curso newCurso) {
        return repository.save(newCurso);
    }

    // Single item

    @GetMapping("/Cursos/{id}")
    Curso one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new CursoNotFoundException(id));
    }

    @PutMapping("/Cursos/{id}")
    Curso replaceCurso(@RequestBody Curso newCurso, @PathVariable Long id) {

        return repository.findById(id)
                .map(curso -> {
                    curso.setNombre(newCurso.getNombre());
                    curso.setHorario(newCurso.getHorario());
                    curso.setHorario(newCurso.getAula());
                    return repository.save(curso);
                })
                .orElseGet(() -> {
                    newCurso.setId(id);
                    return repository.save(newCurso);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
