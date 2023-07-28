package com.edudev.graphql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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


}


