package com.fenrir.example02.generator.strategy;

public class GeneratorStrategyFactory {
    private final GeneratorStrategy excelGeneratorStrategy = new ExcelGeneratorStrategy();
    private final GeneratorStrategy pdfGeneratorStrategy = new PdfGeneratorStrategy();
    private final GeneratorStrategy xmlGeneratorStrategy = new XmlGeneratorStrategy();

    public GeneratorStrategy getStrategy(StrategyType type) {
        return switch (type) {
            case XLSX -> excelGeneratorStrategy;
            case PDF -> pdfGeneratorStrategy;
            case XML -> xmlGeneratorStrategy;
        };
    }
}
