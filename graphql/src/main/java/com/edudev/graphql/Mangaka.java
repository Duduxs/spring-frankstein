package com.edudev.graphql;

import jakarta.persistence.*;

import java.util.Collection;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "tb_mangaka")
public record Mangaka(
        @Id
        @GeneratedValue(strategy = AUTO)
        Long id,

        String name,

        Integer age,

        @Enumerated(STRING)
        Gender gender,

        Float height,

        Float weight,

        @OneToMany(orphanRemoval = true, cascade = {MERGE, REMOVE})
        @JoinColumn(name = "mangaka_id")
        Collection<Manga> mangas

) {
}



