package com.fenrir.example02.generator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum GeneratorType {
    XML("xml"),
    XLSX("xlsx"),
    PDF("pdf");

    private final String extension;

    public String getExtension() {
        return extension;
    }
}
