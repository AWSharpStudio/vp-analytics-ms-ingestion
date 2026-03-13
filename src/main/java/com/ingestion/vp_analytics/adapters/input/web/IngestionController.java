package com.ingestion.vp_analytics.adapters.input.web;

import com.ingestion.vp_analytics.domain.exception.EmptyFileException;
import com.ingestion.vp_analytics.domain.ports.input.ProcessSpreadsheetInputPort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/ingestion")
public class IngestionController {

    private final ProcessSpreadsheetInputPort useCase;

    public IngestionController(ProcessSpreadsheetInputPort useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/spreadsheet")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void ingest(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            throw new EmptyFileException();
        }
        useCase.execute(file);
    }
}
