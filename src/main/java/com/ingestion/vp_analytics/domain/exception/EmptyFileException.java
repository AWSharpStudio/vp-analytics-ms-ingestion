package com.ingestion.vp_analytics.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmptyFileException extends RuntimeException {
    public EmptyFileException() {
        super("O arquivo enviado está vazio.");
    }
}
