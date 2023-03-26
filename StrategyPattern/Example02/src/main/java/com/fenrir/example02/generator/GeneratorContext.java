package com.fenrir.example02.generator;

import com.fenrir.example02.generator.model.DataModel;
import com.fenrir.example02.generator.model.FileEntry;
import com.fenrir.example02.generator.strategy.GeneratorStrategy;
import com.fenrir.example02.generator.strategy.GeneratorStrategyFactory;
import com.fenrir.example02.generator.strategy.StrategyType;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public abstract class GeneratorContext {
    protected final List<FileEntry> entries = new ArrayList<>();
    protected GeneratorStrategy generatorStrategy;

    public GeneratorContext() {
        this.generatorStrategy = new GeneratorStrategyFactory().getStrategy(StrategyType.PDF);
    }

    public abstract void generate(DataModel dataModel) throws Exception;

    public byte[] zip() throws IOException {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             ZipOutputStream zipOut = new ZipOutputStream(out)) {

            zipFiles(zipOut);

            zipOut.flush();
            zipOut.closeEntry();
            zipOut.close();

            return out.toByteArray();
        }
    }

    private void zipFiles(ZipOutputStream zipOut) throws IOException {
        for (int i = 0; i < entries.size(); i++) {
            FileEntry fileEntry = entries.get(i);
            String filename = String.format("file-%d.%s", i + 1, fileEntry.getExtension());
            putZipEntry(zipOut, fileEntry, filename);
        }
    }

    private void putZipEntry(ZipOutputStream zipOut, FileEntry fileEntry, String fileName) throws IOException {
        ZipEntry zipEntry = new ZipEntry(fileName);
        zipOut.putNextEntry(zipEntry);

        byte[] content = fileEntry.getBytes();
        zipOut.write(content, 0, content.length);
    }

    public void setGeneratorStrategy(GeneratorStrategy generatorStrategy) {
        this.generatorStrategy = generatorStrategy;
    }
}
