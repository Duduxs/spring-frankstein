package com.edudev.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

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

    @MutationMapping
    public Mangaka createMangaka(@Argument InputMangaka dto) {
        var mangaka = new Mangaka(null, dto.name, dto.age, Gender.valueOf(dto.gender), dto.height, dto.weight, new ArrayList<>());
        return mangakaRepository.save(mangaka);
    }

    @MutationMapping
    public Mangaka updateMangaka(@Argument Long id, @Argument InputMangaka dto) {
        var mangaka = mangakaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Mangaka not found with id " + id));

        var newMangaka = new Mangaka(mangaka.getId(), dto.name, dto.age, Gender.valueOf(dto.gender), dto.height, dto.weight, new ArrayList<>());
        return mangakaRepository.save(newMangaka);
    }

    @MutationMapping
    public boolean deleteMangaka(@Argument Long id) {
        var mangaka = mangakaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Mangaka not found with id " + id));
        mangakaRepository.delete(mangaka);
        return true;
    }


    public record InputMangaka(String name, Integer age, String gender, Float height, Float weight) {
    }
}
