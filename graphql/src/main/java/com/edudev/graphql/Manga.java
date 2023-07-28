package com.edudev.graphql;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Table(name = "tb_manga")
public record Manga(

        @Id
        @GeneratedValue(strategy = AUTO)
        Long id,

        String name,

        String description,

        Float grade,

        Date releaseAt
) { }
