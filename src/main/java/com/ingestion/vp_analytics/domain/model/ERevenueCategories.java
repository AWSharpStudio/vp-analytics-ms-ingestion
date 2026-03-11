package com.ingestion.vp_analytics.domain.model;

public enum ERevenueCategories {

    PROJECT_SALE("Venda de Projeto"),
    INSTALLMENT("Parcela"), // TODO pensar em como fazer em relação à marcação do 'isNewClient'
    UPSELL("Upsell"),
    REFERRAL("Indicação"),
    NOT_CATEGORIZED("Não Categorizado");

    private final String label;

    ERevenueCategories(String label) {
        this.label = label;
    }

    public static ERevenueCategories labelOf(String label) {
        for (ERevenueCategories value : values()) {
            if (value.label.equals(label)) {
                return value;
            }
        }
        return NOT_CATEGORIZED;
    }
}
