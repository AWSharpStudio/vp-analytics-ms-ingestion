package com.ingestion.vp_analytics.adapters.output.persistence.entity;

import com.ingestion.vp_analytics.domain.model.EExpenseCategories;
import com.ingestion.vp_analytics.domain.model.ERevenueCategories;
import com.ingestion.vp_analytics.domain.model.ETransactionType;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
@NoArgsConstructor
public class TransactionEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "upload_id", nullable = false)
    private String uploadId;

    @Column(name = "date", nullable = false, columnDefinition = "DATE")
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

    @Column(name = "first_purchase_date", columnDefinition = "DATE")
    private LocalDate firstPurchaseDate;

    @Column(name = "value", precision = 15, scale = 2)
    private BigDecimal value;

    public TransactionEntity(String uploadId, LocalDate date, ETransactionType transactionType,
                             EExpenseCategories expenseCategory, ERevenueCategories revenueCategory, String description,
                             Boolean isNewCustomer, LocalDate firstPurchaseDate, BigDecimal value) {
        this.uploadId = uploadId;
        this.date = date;
        this.transactionType = transactionType;
        this.expenseCategory = expenseCategory;
        this.revenueCategory = revenueCategory;
        this.description = description;
        this.isNewCustomer = isNewCustomer;
        this.firstPurchaseDate = firstPurchaseDate;
        this.value = value;
    }
}
