package com.ingestion.vp_analytics.adapters.output.file;

import com.ingestion.vp_analytics.domain.exception.ProcessSpreadSheetException;
import com.ingestion.vp_analytics.domain.model.ETransactionType;
import com.ingestion.vp_analytics.domain.model.ETransactionTypeCategory;
import com.ingestion.vp_analytics.domain.model.Transaction;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CsvExtractorAdapterTest {

    private CsvExtractorAdapter csvExtractor;

    public static final String CSV_HEADER = "date;transactionType;expenseCategory;description;customerId;isNewCustomer;firstPurchaseDate;value";

    @BeforeEach
    void setup() {
        csvExtractor = new CsvExtractorAdapter(new CsvTransactionMapper());
    }

    @Test
    void shouldParseAllValidRows() {
        List<Transaction> result = csvExtractor.extract(csv("transactions-sample.csv"));
        assertEquals(2, result.size());
    }

    @Test
    void shouldCorrectlyMapFirstRowWithoutHeader() {
        Transaction firstRow = csvExtractor.extract(csv("transactions-sample.csv")).getFirst();
        assertEquals(firstRow.date(), LocalDate.of(2025, 1, 15));

        assertEquals(ETransactionType.REVENUE, firstRow.transactionType());
        assertEquals(ETransactionTypeCategory.PAID_TRAFFIC, firstRow.expenseCategory());
        assertEquals("Google Ads campaign", firstRow.description());
        assertEquals("CLI-001", firstRow.customerId());
        assertTrue(firstRow.isNewCostumer());
        assertEquals(LocalDate.of(2025, 1, 15), firstRow.firstPurchaseDate());
        assertEquals(new BigDecimal("4500.00"), firstRow.value());
    }

    @Test
    void shouldHandleEmptyFirstPurchaseDate() {
        Transaction secondRow = csvExtractor.extract(csv("transactions-sample.csv")).get(1);

        assertEquals(ETransactionType.EXPENSE, secondRow.transactionType());
        assertFalse(secondRow.isNewCostumer());
        assertNull(secondRow.firstPurchaseDate());
        assertEquals(new BigDecimal("1200.50"), secondRow.value());
    }

    @Test
    void shouldReturnEmptyListForMalformedRows() {
        byte[] malformed = (CSV_HEADER + "not;enough;columns also;bad").getBytes();
        List<Transaction> result = csvExtractor.extract(new ByteArrayInputStream(malformed));
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnShorterListRow7Columns() {
        List<Transaction> result = csvExtractor.extract(csv("transactions-sample-short-row.csv"));
        assertEquals(1, result.size());
    }

    @Test
    void shouldThrowException() throws IOException, CsvException {
        CSVReader csvReader = Mockito.mock(CSVReader.class);
        when(csvReader.readAll()).thenThrow(ProcessSpreadSheetException.class);

        try {
            csvExtractor.extract(csv("transactions-sample-comma-separator.csv"));
            fail();
        } catch (ProcessSpreadSheetException e) {
            assertEquals("Failed to parse CSV: Text '15/0415/2025' could not be parsed at index 5", e.getMessage());
        }
    }

    private InputStream csv(String name) {
        return getClass().getClassLoader().getResourceAsStream(name);
    }
}

