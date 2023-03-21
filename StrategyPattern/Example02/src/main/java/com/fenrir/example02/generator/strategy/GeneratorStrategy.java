package com.fenrir.example02.generator.strategy;

import com.fenrir.example02.generator.model.DataModel;

import java.io.OutputStream;

public interface GeneratorStrategy {
    void generate(DataModel model, OutputStream outputStream) throws Exception;
    String extension();
}
