package com.edudev.multitenant.entities;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = IDENTITY)

    private Long id;
    @Column(name = "title")
    private String title;

    public Note() {
    }

    public Note(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
