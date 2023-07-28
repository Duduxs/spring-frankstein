package com.edudev.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MangaResource {

    private MangaRepository repository;

    @Autowired
    public MangaResource(MangaRepository repository) {
        this.repository = repository;
    }

    @QueryMapping
    Manga findById(@Argument Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Manga not found with id " + id));
    }

    @QueryMapping
    Iterable<Manga> findAll() {
        return repository.findAll();
    }

}
