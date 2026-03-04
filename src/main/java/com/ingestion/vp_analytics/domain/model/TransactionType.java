package com.ingestion.vp_analytics.domain.model;

import lombok.Getter;

@Getter
public enum TransactionType {
    REVENUE("Receita"),
    EXPENSE("Despesa");

    private final String label;

    TransactionType(String label) {
        this.label = label;
    }
}