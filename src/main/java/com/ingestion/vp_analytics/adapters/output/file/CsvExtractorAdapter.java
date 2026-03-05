package com.ingestion.vp_analytics.adapters.output.file;

import com.ingestion.vp_analytics.domain.exception.ProcessSpreadSheetException;
import com.ingestion.vp_analytics.domain.model.Transaction;
import com.ingestion.vp_analytics.domain.ports.output.SpreadsheetExtractorPort;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class CsvExtractorAdapter implements SpreadsheetExtractorPort {

    private final CsvTransactionMapper mapper;

    public CsvExtractorAdapter(CsvTransactionMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Transaction> extract(InputStream inputStream) {
        try {
            CSVReader reader = new CSVReaderBuilder(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                    .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                    .withSkipLines(1)
                    .build();

            return reader.readAll().stream()
                    .filter(row -> row.length >= 8)
                    .map(mapper::map)
                    .toList();
        } catch (Exception e) {
            throw new ProcessSpreadSheetException("Failed to parse CSV: " + e.getMessage());
        }
    }
}
