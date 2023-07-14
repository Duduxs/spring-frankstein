package com.edudev.multitenant.services;

import com.edudev.multitenant.entities.Note;
import com.edudev.multitenant.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository repository;

    public List<Note> findAll() {
        return repository.findAll();
    }

    public Note create(Note node) {
        return repository.save(node);
    }


}
