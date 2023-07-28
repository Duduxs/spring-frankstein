package com.edudev.graphql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "tb_manga")
@NoArgsConstructor
@AllArgsConstructor
public final class Manga {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Getter
    private final Long id = null;

    @Getter
    private final String name = null;

    @Getter
    private final String description = null;

    @Getter
    private final Float grade = 0f;


}


