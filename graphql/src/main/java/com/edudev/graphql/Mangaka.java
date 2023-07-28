package com.edudev.graphql;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.REMOVE;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "tb_mangaka")
@NoArgsConstructor(force = true)
@AllArgsConstructor
public final class Mangaka {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Getter
    private final Long id;

    @Getter
    private final String name;

    @Getter
    private final Integer age;

    @Enumerated(STRING)
    @Getter
    private final Gender gender;

    @Getter
    private final Float height;

    @Getter
    private final Float weight;

    @OneToMany(orphanRemoval = true, cascade = {MERGE, REMOVE})
    @JoinColumn(name = "mangaka_id")
    @Getter
    private final Collection<Manga> mangas;

}



