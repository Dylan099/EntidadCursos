package com.CultOfTheUnicorn.demo;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class CursoResourceAssembler implements ResourceAssembler<Curso,Resource<Curso>> {
    @Override
    public Resource<Curso> toResource(Curso curso){
        return new Resource<>(curso,
                linkTo(methodOn(CursoController.class).one(curso.getId())).withSelfRel(),
                linkTo(methodOn(CursoController.class).all()).withRel("employees"));
    }
}
