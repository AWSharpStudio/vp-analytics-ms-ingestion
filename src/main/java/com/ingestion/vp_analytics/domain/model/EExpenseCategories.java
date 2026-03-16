package com.ingestion.vp_analytics.domain.model;

import lombok.Getter;

@Getter
public enum EExpenseCategories {
    PAID_TRAFFIC("Trafego Pago"),
    SALES_TEAM("Equipe de Vendas"),
    MARKETING_TEAM("Equipe de Marketing"),
    PRO_LABORE("Pró-labore"),
    TAXES("Impostos"),
    NOT_CATEGORIZED("Não Categorizado");

    private final String label;

    EExpenseCategories(String label) {
        this.label = label;
    }

    public static EExpenseCategories labelOf(String label) {
        for (EExpenseCategories value : values()) {
            if (value.label.equals(label)) {
                return value;
            }
        }
        return NOT_CATEGORIZED;
    }
}