package com.edudev.multitenant.resources;

import com.edudev.multitenant.entities.Note;
import com.edudev.multitenant.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteResource {

    @Autowired
    private NoteService service;

    @GetMapping
    public List<Note> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Note create(@RequestBody Note note) {
        return service.create(note);
    }

}
