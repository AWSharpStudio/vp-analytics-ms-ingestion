package com.ingestion.vp_analytics.domain.exception;

public class DuplicateFileException extends RuntimeException {
    public DuplicateFileException(String fileHash) {
        super("File with hash [" + fileHash + "] has already been processed.");
    }
}
