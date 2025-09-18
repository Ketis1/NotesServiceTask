package com.example.notesservice.controller;


import com.example.notesservice.dto.AuthorRequest;
import com.example.notesservice.model.Author;
import com.example.notesservice.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }


    //      --- USING REQUEST BODY AND DTO ---
//    @PostMapping
//    public Author create(@Valid @RequestBody AuthorRequest request) {
//        Author author = new Author();
//        author.setName(request.getName());
//        return service.save(author);
//    }

    //      --- USING REQUEST PARAM ---
    @PostMapping("/create")
    public Author create(@RequestParam String name) {
        if (name == null || name.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name is required");
        }
        if (name.length() > 100) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name is too long");
        }

        Author author = new Author();
        author.setName(name.trim());
        return service.save(author);
    }




    @GetMapping
    public List<Author> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Author getById(@PathVariable Long id) {
        return service.findById(id);
    }
}