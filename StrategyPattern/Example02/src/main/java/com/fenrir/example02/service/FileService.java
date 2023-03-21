package com.fenrir.example02.service;

import com.fenrir.example02.generator.GeneratorContext;
import com.fenrir.example02.generator.StrategyType;
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

    public byte[] generateFile(DataModel dataModel, List<StrategyType> types) {
        try {
            GeneratorContext context = new GeneratorContext();
            generate(context, dataModel, types);

            return context.zip();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void generate(GeneratorContext context, DataModel dataModel, List<StrategyType> types) throws Exception {
        for (StrategyType type: types) {
            GeneratorStrategy strategy = getStrategy(type);
            context.setGeneratorStrategy(strategy);
            context.generate(dataModel);
        }
    }

    private GeneratorStrategy getStrategy(StrategyType strategyType) {
        return switch (strategyType) {
            case XML -> new XmlGeneratorStrategy();
            case XLSX -> new ExcelGeneratorStrategy();
            case PDF -> new PdfGeneratorStrategy();
        };
    }
}
