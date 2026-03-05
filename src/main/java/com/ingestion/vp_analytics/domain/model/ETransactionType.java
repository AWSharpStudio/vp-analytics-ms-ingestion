package com.ingestion.vp_analytics.domain.model;

import lombok.Getter;

@Getter
public enum ETransactionType {
    REVENUE("Receita"),
    EXPENSE("Despesa");

    private final String label;

    ETransactionType(String label) {
        this.label = label;
    }
}