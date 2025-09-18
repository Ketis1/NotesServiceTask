package com.example.notesservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorRequest {
    @NotBlank(message = "Name is required")
    private String name;
}