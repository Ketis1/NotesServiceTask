package com.example.notesservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteRequest {
    @NotBlank(message = "Title is required")
    private String title;

    private String content;

    @NotNull(message = "Author ID is required")
    private Long authorId;
}