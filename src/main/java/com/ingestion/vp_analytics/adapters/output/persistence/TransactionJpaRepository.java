package com.ingestion.vp_analytics.adapters.output.persistence;

import com.ingestion.vp_analytics.adapters.output.persistence.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionJpaRepository extends JpaRepository<TransactionEntity, String> {
}
