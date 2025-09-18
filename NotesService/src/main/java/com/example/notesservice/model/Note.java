package com.example.notesservice.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    private String content;

    private LocalDateTime createdAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
