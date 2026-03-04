package com.ingestion.vp_analytics.domain;

public class DuplicateFileException extends RuntimeException {
    public DuplicateFileException(String fileHash) {
        super("File with hash [" + fileHash + "] has already been processed.");
    }
}
