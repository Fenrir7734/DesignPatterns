package com.fenrir.example02.generator;

import com.fenrir.example02.generator.model.DataModel;
import com.fenrir.example02.generator.model.FileEntry;

import java.io.ByteArrayOutputStream;

public class PlainTextGeneratorContext extends GeneratorContext {

    public void generate(DataModel dataModel) throws Exception {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()){
            generatorStrategy.generate(dataModel, out);
            FileEntry fileEntry = new FileEntry(generatorStrategy.extension(), out.toByteArray());
            entries.add(fileEntry);
        }
    }
}
