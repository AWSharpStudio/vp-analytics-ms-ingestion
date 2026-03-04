package com.ingestion.vp_analytics.domain.model;

import lombok.Getter;

@Getter
public enum ETransactionTypeCategory {
    PAID_TRAFFIC("Trafego Pago"),
    SALES_TEAM("Equipe de vendas"),
    MARKETING_TEAM("Equipe de Marketing"),
    PRO_LABORE("Pró-labore"),
    TAXES("Impostos");

    private final String label;

    ETransactionTypeCategory(String label) {
        this.label = label;
    }
}