package org.factorymethod.factory.writer;

import org.factorymethod.factory.model.AbstractModel;
import org.factorymethod.factory.model.JsonModel;

import java.util.Map;

public class JsonWriter extends AbstractWriter {
    @Override
    protected AbstractModel createModel(Map<String, String> data) {
        return new JsonModel(data);
    }
}
