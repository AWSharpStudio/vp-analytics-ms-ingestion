package com.ingestion.vp_analytics.domain.ports.output;

import com.ingestion.vp_analytics.domain.model.SpreadsheetUpload;
import com.ingestion.vp_analytics.domain.model.Transaction;
import com.ingestion.vp_analytics.domain.model.UploadStatus;

import java.util.List;

public interface TransactionRepositoryPort {
    boolean existsByFileHash(String fileHash);

    SpreadsheetUpload saveUpload(Object any);

    SpreadsheetUpload updateUploadStatus(String fileId, UploadStatus status);

    void saveTransactions(List<Transaction> transactions, String fileId);
}
