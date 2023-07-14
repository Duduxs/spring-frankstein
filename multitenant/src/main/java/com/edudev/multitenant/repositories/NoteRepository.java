package com.edudev.multitenant.repositories;

import com.edudev.multitenant.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> { }
