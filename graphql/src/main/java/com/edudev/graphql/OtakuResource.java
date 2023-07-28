package com.edudev.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class OtakuResource {

    private MangaRepository mangaRepository;
    private MangakaRepository mangakaRepository;

    @Autowired
    public OtakuResource(MangaRepository mangaRepository, MangakaRepository mangakaRepository) {
        this.mangaRepository = mangaRepository;
        this.mangakaRepository = mangakaRepository;
    }


    @QueryMapping
    Mangaka findById(@Argument Long id) {
        return mangakaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Mangaka not found with id " + id));
    }

    @QueryMapping
    Iterable<Mangaka> findAll() {
        return mangakaRepository.findAll();
    }


}
