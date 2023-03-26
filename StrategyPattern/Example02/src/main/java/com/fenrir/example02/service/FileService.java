package com.fenrir.example02.service;

import com.fenrir.example02.generator.GeneratorContext;
import com.fenrir.example02.generator.GeneratorContextFactory;
import com.fenrir.example02.generator.GeneratorType;
import com.fenrir.example02.generator.strategy.GeneratorStrategyFactory;
import com.fenrir.example02.generator.strategy.StrategyType;
import com.fenrir.example02.generator.model.DataModel;
import com.fenrir.example02.generator.strategy.GeneratorStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileService {
    private final GeneratorContextFactory generatorContextFactory = new GeneratorContextFactory();
    private final GeneratorStrategyFactory generatorStrategyFactory = new GeneratorStrategyFactory();

    public byte[] generateFile(DataModel dataModel, GeneratorType generatorType, List<StrategyType> strategyTypes) {
        try {
            GeneratorContext context = generatorContextFactory.getGenerator(generatorType);
            generate(context, dataModel, strategyTypes);

            return context.zip();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void generate(GeneratorContext context, DataModel dataModel, List<StrategyType> types) throws Exception {
        for (StrategyType type: types) {
            GeneratorStrategy strategy = generatorStrategyFactory.getStrategy(type);
            context.setGeneratorStrategy(strategy);
            context.generate(dataModel);
        }
    }
}
