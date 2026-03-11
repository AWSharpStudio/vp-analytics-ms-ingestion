package com.ingestion.vp_analytics.adapters.output.persistence.entity;

import com.ingestion.vp_analytics.domain.model.UploadStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "spreadsheet_uploads")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SpreadsheetUploadEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "file_hash", nullable = false, unique = true)
    private String fileHash;

    @Column(name = "original_file_name")
    private String originalFileName;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private UploadStatus status;

    @Column(name = "create_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
