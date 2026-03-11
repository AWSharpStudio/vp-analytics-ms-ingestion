package com.ingestion.vp_analytics.adapters.output.persistence.entity;

import com.ingestion.vp_analytics.domain.model.EExpenseCategories;
import com.ingestion.vp_analytics.domain.model.ERevenueCategories;
import com.ingestion.vp_analytics.domain.model.ETransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "financial_transactions")
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "upload_id", nullable = false)
    private String uploadId;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false)
    private ETransactionType transactionType;

    @Enumerated(EnumType.STRING)
    @Column(name = "expense_category")
    private EExpenseCategories expenseCategory;

    @Enumerated(EnumType.STRING)
    @Column(name = "revenue_category")
    private ERevenueCategories revenueCategory;

    @Column(name = "description")
    private String description;

    @Column(name = "is_new_customer")
    private Boolean isNewCustomer;

    @Column(name = "first_purchase_date")
    private LocalDate firstPurchaseDate;

    @Column(name = "value", precision = 15, scale = 2)
    private BigDecimal value;
}
