package com.ingestion.vp_analytics.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Transaction(
        LocalDate date,
        TransactionType transactionType,
        ETransactionTypeCategory expenseCategory,
        String description,
        String customerId,
        boolean isNewCostumer,
        LocalDate firstPurchaseDate,
        BigDecimal value
) {
}
