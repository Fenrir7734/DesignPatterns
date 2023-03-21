package com.fenrir.example02.generator.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FileEntry {
    private final String extension;
    private final byte[] bytes;
}
