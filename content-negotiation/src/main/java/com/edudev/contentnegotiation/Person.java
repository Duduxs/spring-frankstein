package com.edudev.contentnegotiation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

public record Person(
        Long id,
        String name,

        GENDER gender,

        LocalDate birthdate,

        @JsonProperty(access = READ_ONLY)
        Integer age,
        Collection<Game> favoriteGames
) {
}

record Game(String name, String style){}

enum GENDER {
    MALE, FEMALE
}
