package com.example.notesservice.controller;


import com.example.notesservice.dto.NoteRequest;
import com.example.notesservice.model.Note;
import com.example.notesservice.service.AuthorService;
import com.example.notesservice.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;
    private final AuthorService authorService;

    public NoteController(NoteService noteService, AuthorService authorService) {
        this.noteService = noteService;
        this.authorService = authorService;
    }

    @PostMapping
    public Note create(@Valid @RequestBody NoteRequest request) {
        Note note = new Note();
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        note.setAuthor(authorService.findById(request.getAuthorId()));
        return noteService.save(note);
    }

    @GetMapping
    public List<Note> getAll() {
        return noteService.findAll();
    }

    @GetMapping("/{id}")
    public Note getById(@PathVariable Long id) {
        return noteService.findById(id);
    }

    //not found handling in the noteservice
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        noteService.deleteById(id);
    }

//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        if (!noteService.existsById(id)) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found");
//        }
//        noteService.deleteById(id);
//    }
}