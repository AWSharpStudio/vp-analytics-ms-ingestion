package com.ingestion.vp_analytics.domain.model;

import java.time.LocalDateTime;

public record SpreadsheetUpload(
        String id,
        String fileHash,
        String originalFileName,
        UploadStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
