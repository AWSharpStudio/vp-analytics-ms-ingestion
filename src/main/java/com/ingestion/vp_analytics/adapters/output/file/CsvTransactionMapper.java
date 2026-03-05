package com.ingestion.vp_analytics.adapters.output.file;

import com.ingestion.vp_analytics.domain.model.ETransactionType;
import com.ingestion.vp_analytics.domain.model.ETransactionTypeCategory;
import com.ingestion.vp_analytics.domain.model.Transaction;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//Column mapping:
//0 = date (dd/MM/yyyy)
//1 = transactionType
//2 = expenseCategory
//3 = description
//4 = customerId
//5 = isNewCustomer
//6 = firstPurchaseDate (may be empty, dd/MM/yyyy)
//7 = value (Brazilian decimal format)

@Component
public class CsvTransactionMapper {

    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Transaction map(String[] row) {
        LocalDate firstPurchase = null;
        if (!row[6].trim().isEmpty()) {
            firstPurchase = LocalDate.parse(row[6].trim(), DATE_FORMAT);
        }
        return new Transaction(LocalDate.parse(row[0].trim(), DATE_FORMAT),
                ETransactionType.valueOf(row[1].trim().toUpperCase()),
                ETransactionTypeCategory.valueOf(row[2].trim().toUpperCase()),
                row[3].trim(),
                row[4].trim(),
                Boolean.parseBoolean(row[5].trim()),
                firstPurchase,
                new BigDecimal(row[7].trim().replace(".", "").replace(",", ".")));
    }
}
