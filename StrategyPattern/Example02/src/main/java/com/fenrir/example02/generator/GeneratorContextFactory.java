package com.fenrir.example02.generator;

public class GeneratorContextFactory {

    public GeneratorContext getGenerator(GeneratorType type) {
        return switch (type) {
            case PLAIN_TEXT -> new PlainTextGeneratorContext();
            case ENCRYPTION -> new EncryptionGeneratorContext();
        };
    }
}
