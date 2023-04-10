package org.factorymethod.without;

import org.factorymethod.without.model.AbstractModel;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        final Map<String, String> values = Map.of("field1", "value1", "field2", "value2");

        Writer jsonWriter = new Writer();
        AbstractModel jsonModel = jsonWriter.write(values, FileTypes.JSON);
        System.out.println(jsonModel.getPath());

        Writer yamlWriter = new Writer();
        AbstractModel yamlModel = yamlWriter.write(values, FileTypes.YAML);
        System.out.println(yamlModel.getPath());
    }
}
