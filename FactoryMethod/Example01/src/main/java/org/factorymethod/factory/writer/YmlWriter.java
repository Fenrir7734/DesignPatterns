package org.factorymethod.factory.writer;

import org.factorymethod.factory.model.AbstractModel;
import org.factorymethod.factory.model.YamlModel;

import java.util.Map;

public class YmlWriter extends AbstractWriter {
    @Override
    protected AbstractModel createModel(Map<String, String> data) {
        return new YamlModel(data);
    }
}
