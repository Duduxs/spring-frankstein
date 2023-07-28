package com.edudev.graphql;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "tb_manga")
@NoArgsConstructor(force = true)
@AllArgsConstructor
public final class Manga {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Getter
    private final Long id;

    @Getter
    private final String name;

    @Getter
    private final String description;

    @Getter
    private final Float grade;

    @Getter
    @ManyToOne(fetch = LAZY)
    private final Mangaka mangaka;


}


