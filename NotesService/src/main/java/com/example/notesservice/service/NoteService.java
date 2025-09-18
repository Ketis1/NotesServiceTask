package com.example.notesservice.service;

import com.example.notesservice.model.Note;
import com.example.notesservice.repository.NoteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository repository;

    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public Note save(Note note) {
        return repository.save(note);
    }

    public List<Note> findAll() {
        return repository.findAll();
    }

    public Note findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found");
        }
        repository.deleteById(id);
    }

    private boolean existsById(Long id) {
        return repository.existsById(id);
    }
}