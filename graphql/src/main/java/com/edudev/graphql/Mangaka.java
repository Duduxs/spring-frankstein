package com.edudev.graphql;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.REMOVE;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "tb_mangaka")
@NoArgsConstructor
@AllArgsConstructor
public final class Mangaka {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Getter
    private final Long id = 0L;

    @Getter
    private final String name = null;

    @Getter
    private final Integer age = 0;

    @Enumerated(STRING)
    @Getter
    private final Gender gender = null;

    @Getter
    private final Float height = 0.0f;

    @Getter
    private final Float weight = 0.0f;

    @OneToMany(orphanRemoval = true, cascade = {MERGE, REMOVE})
    @JoinColumn(name = "mangaka_id")
    @Getter
    private final Collection<Manga> mangas = new ArrayList<>();


}



