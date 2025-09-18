package com.example.notesservice.service;


import com.example.notesservice.model.Author;
import com.example.notesservice.repository.AuthorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public Author save(Author author) {
        return repository.save(author);
    }

    public List<Author> findAll() {
        return repository.findAll();
    }

    public Author findById(Long authorId) {
        return repository.findById(authorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found"));
    }
}