package com.fenrir.example02.service;

import com.fenrir.example02.generator.GeneratorContext;
import com.fenrir.example02.generator.GeneratorType;
import com.fenrir.example02.generator.model.DataModel;
import com.fenrir.example02.generator.strategy.ExcelGeneratorStrategy;
import com.fenrir.example02.generator.strategy.GeneratorStrategy;
import com.fenrir.example02.generator.strategy.PdfGeneratorStrategy;
import com.fenrir.example02.generator.strategy.XmlGeneratorStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileService {

    public byte[] generateFile(DataModel dataModel, List<GeneratorType> types) {
        try {
            GeneratorContext context = new GeneratorContext();
            generate(context, dataModel, types);

            return context.zip();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void generate(GeneratorContext context, DataModel dataModel, List<GeneratorType> types) throws Exception {
        for (GeneratorType type: types) {
            GeneratorStrategy strategy = getStrategy(type);
            context.setGeneratorStrategy(strategy);
            context.generate(dataModel);
        }
    }

    private GeneratorStrategy getStrategy(GeneratorType generatorType) {
        return switch (generatorType) {
            case XML -> new XmlGeneratorStrategy();
            case XLSX -> new ExcelGeneratorStrategy();
            case PDF -> new PdfGeneratorStrategy();
        };
    }
}
