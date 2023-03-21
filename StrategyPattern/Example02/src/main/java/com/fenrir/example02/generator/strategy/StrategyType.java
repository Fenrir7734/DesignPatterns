package com.fenrir.example02.generator.strategy;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum StrategyType {
    XML("xml"),
    XLSX("xlsx"),
    PDF("pdf");

    private final String extension;

    public String getExtension() {
        return extension;
    }
}
