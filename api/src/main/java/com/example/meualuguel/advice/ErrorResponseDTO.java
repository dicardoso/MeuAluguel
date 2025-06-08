package com.example.meualuguel.advice;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponseDTO {
    private String error;
    private int status;
    private String path;
    private LocalDateTime timestamp;
}
